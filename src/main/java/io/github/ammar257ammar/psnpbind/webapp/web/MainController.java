package io.github.ammar257ammar.psnpbind.webapp.web;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import io.github.ammar257ammar.psnpbind.webapp.domain.MutatedProtein;
import io.github.ammar257ammar.psnpbind.webapp.domain.MutatedProteinLigand;
import io.github.ammar257ammar.psnpbind.webapp.domain.MutatedProteinLigandId;
import io.github.ammar257ammar.psnpbind.webapp.domain.Protein;
import io.github.ammar257ammar.psnpbind.webapp.jsonld.ProteinJsonLd;
import io.github.ammar257ammar.psnpbind.webapp.service.MutatedProteinLigandService;
import io.github.ammar257ammar.psnpbind.webapp.service.MutatedProteinService;
import io.github.ammar257ammar.psnpbind.webapp.service.ProteinService;
import ioinformarics.oss.jackson.module.jsonld.JsonldModule;
import ioinformarics.oss.jackson.module.jsonld.JsonldResource;

@Controller
public class MainController {

	@Autowired
    private ProteinService proteinService;
	
	@Autowired
	private MutatedProteinService proteinVariantService;
	
	@Autowired
	private MutatedProteinLigandService mutatedProteinLigandService;
 
    @GetMapping("/")
    public ModelAndView getProteins() {

    	List<Protein> proteins = (List<Protein>) proteinService.findAll();

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("proteins", proteins);

        return new ModelAndView("proteins", params);
    }
    
    @GetMapping("/protein/{pdbId}")
    public ModelAndView getProtein(@PathVariable(value="pdbId") String pdbId) {

    	Protein protein = (Protein) proteinService.findOneByPdbId(pdbId);

    	ObjectMapper objectMapper = new ObjectMapper();
    	objectMapper.registerModule(new JsonldModule());
    	objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
    	objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

    	String proteinJsonLd = "";

    	if(protein == null) {
    		return new ModelAndView("notfound");
    	}
    	
    	ProteinJsonLd pld = new ProteinJsonLd(protein.getPdbId(), protein.getProteinUuid(),
				protein.getProteinName(), 
				protein.getUniprotId());

		try {
			proteinJsonLd = objectMapper.writeValueAsString(JsonldResource.Builder.create().build(pld));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("protein", protein);
        params.put("proteinJsonLd", proteinJsonLd);

        return new ModelAndView("protein", params);
    }
    
    @GetMapping("/variant/{variantId}")
    public ModelAndView getVariant(@PathVariable(value="variantId") Long variantId) {

    	MutatedProtein variant = (MutatedProtein) proteinVariantService.findOneByVariantId(variantId);
    	
    	if(variant == null) {
    		return new ModelAndView("notfound");
    	}
    	
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("variant", variant);

        return new ModelAndView("variant", params);
    }
    
    @GetMapping("/variant/{variantId}/ligand/{ligandId}")
    public ModelAndView getVariantLigandComplex(@PathVariable(value="variantId") String variantId,
    											@PathVariable(value="ligandId") String ligandId) {

    	MutatedProteinLigand vl = (MutatedProteinLigand)  mutatedProteinLigandService.findOneById(
    									new MutatedProteinLigandId(Long.parseLong(variantId), ligandId));
    	
    	if(vl == null) {
    		return new ModelAndView("notfound");
    	}
    	
    	String[] conformers = vl.getBindingAffinity().split(";");
    	    	
    	String wtVariantFolder = "_WT";
    	String listString = "";
    	
    	if(!vl.getVlVariant().getVariantType().equals("WT")){
          
          wtVariantFolder = vl.getVariantFolder().substring(0, vl.getVariantFolder().lastIndexOf('_'))+"_WT";
          listString = "Binding Affiniy against the Wild-type protein";          
        }else {
          wtVariantFolder = vl.getVlVariant().getProtein().getPdbId().toLowerCase()+"_";
          listString = "Binding Affinities Against Other "+vl.getVlVariant().getProtein().getPdbId()+" Variants";
        }
    	
    	List<MutatedProteinLigand> wtList = mutatedProteinLigandService.findByVariantFolderLikeAndVlLigandAndVlVariantNot("%"+wtVariantFolder+"%", vl.getVlLigand(), vl.getVlVariant());
        
    	for(int i = 0; i < wtList.size(); i++) {
    	  
    	  String firstBindingAffinity = wtList.get(i).getBindingAffinity().split(";")[0];
    	  
    	  wtList.get(i).setBindingAffinity(firstBindingAffinity);
    	}
    	
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("vl", vl);
        params.put("conformers", conformers);
        
        params.put("wtList", wtList);
        params.put("listString", listString);
        
        return new ModelAndView("complex", params);
    }
    
    @GetMapping("/methodology")
    public ModelAndView getMethodology() {

        Map<String, Object> params = new HashMap<String, Object>();

        return new ModelAndView("methodology", params);
    }
    
    @GetMapping("/stats")
    public ModelAndView getStatistics() {

        Map<String, Object> params = new HashMap<String, Object>();

        return new ModelAndView("stats", params);
    }
    
    @GetMapping("/citation")
    public ModelAndView getCitation() {

        Map<String, Object> params = new HashMap<String, Object>();

        return new ModelAndView("citation", params);
    }
    
    @RequestMapping(value = "/sitemap.xml",method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
    public @ResponseBody ModelAndView  generateSitemap(HttpServletResponse response) throws IOException {
        
        response.setContentType(MediaType.APPLICATION_XML_VALUE); 

        Map<String, Object> params = new HashMap<String, Object>();

        params.put("DATE", OffsetDateTime.now(ZoneOffset.UTC).toString());
        
        return new ModelAndView("sitemap", params);
    }
    
    @RequestMapping(value = "/robots.txt",method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public @ResponseBody ModelAndView  generateRobots(HttpServletResponse response) throws IOException {
        
        response.setContentType(MediaType.TEXT_PLAIN_VALUE); 
        
        return new ModelAndView("robots");
    }
}

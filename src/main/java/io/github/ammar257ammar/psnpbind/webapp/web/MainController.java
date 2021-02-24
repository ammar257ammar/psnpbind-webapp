package io.github.ammar257ammar.psnpbind.webapp.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    	if(protein != null) {

        	ProteinJsonLd pld = new ProteinJsonLd(protein.getPdbId(), 
					protein.getProteinName(), 
					protein.getUniprotId());

			try {
				proteinJsonLd = objectMapper.writeValueAsString(JsonldResource.Builder.create().build(pld));
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
    	}

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("protein", protein);
        params.put("proteinJsonLd", proteinJsonLd);

        return new ModelAndView("protein", params);
    }
    
    @GetMapping("/variant/{variantId}")
    public ModelAndView getVariant(@PathVariable(value="variantId") Long variantId) {

    	MutatedProtein variant = (MutatedProtein) proteinVariantService.findOneByVariantId(variantId);

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("variant", variant);

        return new ModelAndView("variant", params);
    }
    
    @GetMapping("/variant/{variantId}/ligand/{ligandId}")
    public ModelAndView getVariantLigandComplex(@PathVariable(value="variantId") String variantId,
    											@PathVariable(value="ligandId") String ligandId) {

    	MutatedProteinLigand vl = (MutatedProteinLigand)  mutatedProteinLigandService.findOneById(
    									new MutatedProteinLigandId(Long.parseLong(variantId), ligandId));
    	
    	String[] conformers = vl.getBindingAffinity().split(";");
    	
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("vl", vl);
        params.put("conformers", conformers);
        
        return new ModelAndView("complex", params);
    }
    
    @GetMapping("/methodology")
    public ModelAndView getMethodology() {

        Map<String, Object> params = new HashMap<String, Object>();

        return new ModelAndView("methodology", params);
    }
}

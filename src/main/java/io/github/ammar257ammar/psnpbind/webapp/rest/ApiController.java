package io.github.ammar257ammar.psnpbind.webapp.rest;

import java.time.Instant;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.github.ammar257ammar.psnpbind.webapp.domain.Ligand;
import io.github.ammar257ammar.psnpbind.webapp.domain.MutatedProtein;
import io.github.ammar257ammar.psnpbind.webapp.domain.MutatedProteinLigand;
import io.github.ammar257ammar.psnpbind.webapp.domain.MutatedProteinLigandId;
import io.github.ammar257ammar.psnpbind.webapp.domain.Protein;
import io.github.ammar257ammar.psnpbind.webapp.service.LigandService;
import io.github.ammar257ammar.psnpbind.webapp.service.MutatedProteinLigandService;
import io.github.ammar257ammar.psnpbind.webapp.service.MutatedProteinService;
import io.github.ammar257ammar.psnpbind.webapp.service.ProteinService;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@Tag(name = "contact", description = "the Contact API")
public class ApiController {

	@Autowired
    private ProteinService proteinService;
	
	@Autowired
	private MutatedProteinService proteinVariantService;
	
	@Autowired
	private LigandService ligandService;
	
	@Autowired
	private MutatedProteinLigandService mutatedProteinLigandService;
 
    @Operation(summary = "List all proteins", description = "Retrieve all the proteins in PSnpbind with their information", tags = { "protein" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "successful operation", 
                content = @Content(array = @ArraySchema(schema = @Schema(implementation = Protein.class)))) })	
    @GetMapping("/api/v1/protein/list")
    public List<Protein> getProteins() {
        return proteinService.findAll();
    }
    
    @Operation(summary = "Get protein by PDB ID", description = "Returns a single protein", tags = { "protein" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "successful operation",
                content = @Content(schema = @Schema(implementation = Protein.class))),
        @ApiResponse(responseCode = "404", description = "Protein not found",
        		content = @Content(schema = @Schema(implementation = ErrorPayload.class))) })
    @GetMapping("/api/v1/protein/{pdbId}")
    public Protein getProtein(@Parameter(description = "PDB ID of protein to be searched") 
    		@PathVariable(value="pdbId") String pdbId) {
    	
    	Protein protein = proteinService.findOneByPdbId(pdbId);
		
    	if(protein == null) {
			throw new ResponseStatusException(
					  HttpStatus.NOT_FOUND, "entity not found"
					);
		}
    	
        return protein;
    }

    @Operation(summary = "Get protein by UUID", description = "Returns a single protein", tags = { "protein" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "successful operation",
                content = @Content(schema = @Schema(implementation = Protein.class))),
        @ApiResponse(responseCode = "404", description = "Protein not found",
        		content = @Content(schema = @Schema(implementation = ErrorPayload.class))) })
    @GetMapping("/api/v1/protein/uuid/{proteinUuid}")
    public Protein getProteinByUuid(@Parameter(description = "UUID of protein to be searched") 
    		@PathVariable(value="proteinUuid") String proteinUuid) {
    	
    	Protein protein = proteinService.findOneByProteinUuid(proteinUuid);

    	if(protein == null) {
			throw new ResponseStatusException(
					  HttpStatus.NOT_FOUND, "entity not found"
					);
		}
    	
        return protein;
    }
    
    @Operation(summary = "List proteins variants (by PDB ID)", description = "Returns a list of variants for the specified protein", tags = { "protein" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "successful operation",
                content = @Content(schema = @Schema(implementation = MutatedProtein.class))),
        @ApiResponse(responseCode = "404", description = "Protein not found",
        		content = @Content(schema = @Schema(implementation = ErrorPayload.class))) })
    @GetMapping("/api/v1/protein/{pdbId}/variants")
    public Set<MutatedProtein> getProteinVariants(@Parameter(description = "PDB ID of protein to be searched") 
    		@PathVariable(value="pdbId") String pdbId) {
    	
    	Protein protein = proteinService.findOneByPdbId(pdbId);

    	if(protein == null) {
			throw new ResponseStatusException(
					  HttpStatus.NOT_FOUND, "entity not found"
					);
		}
    	
        return protein.getVariants();
    }
    
    @Operation(summary = "Get a mutant protein by variant ID", description = "Returns a single mutant protein", tags = { "variant" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "successful operation",
                content = @Content(schema = @Schema(implementation = MutatedProtein.class))),
        @ApiResponse(responseCode = "404", description = "Mutant protein not found",
        		content = @Content(schema = @Schema(implementation = ErrorPayload.class))) })
    @GetMapping("/api/v1/variant/{variantId}")
    public MutatedProtein getVariant(@Parameter(description = "ID of mutant protein to be searched") 
    		@PathVariable(value="variantId") Long variantId) {
    	
    	MutatedProtein variant = proteinVariantService.findOneByVariantId(variantId);

    	if(variant == null) {
			throw new ResponseStatusException(
					  HttpStatus.NOT_FOUND, "entity not found"
					);
		}
    	
        return variant;        
    }
    
    @Operation(summary = "Get a mutant protein by variant UUID", description = "Returns a single mutant protein", tags = { "variant" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "successful operation",
                content = @Content(schema = @Schema(implementation = MutatedProtein.class))),
        @ApiResponse(responseCode = "404", description = "Mutant protein not found",
        		content = @Content(schema = @Schema(implementation = ErrorPayload.class))) })    
    @GetMapping("/api/v1/variant/uuid/{variantUuid}")
    public MutatedProtein getVariantByUuid(@Parameter(description = "UUID of mutant protein to be searched") 
    		@PathVariable(value="variantUuid") Long variantUuid) {
    	
    	MutatedProtein variant = proteinVariantService.findOneByVariantUuid(variantUuid);

    	if(variant == null) {
			throw new ResponseStatusException(
					  HttpStatus.NOT_FOUND, "entity not found"
					);
		}
    	
        return variant; 
    }
    
    @Operation(summary = "Get a ligand by ChEMBL ID", description = "Returns a single ligand", tags = { "ligand" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "successful operation",
                content = @Content(schema = @Schema(implementation = Ligand.class))),
        @ApiResponse(responseCode = "404", description = "Ligand not found",
        		content = @Content(schema = @Schema(implementation = ErrorPayload.class))) })
    @GetMapping("/api/v1/ligand/{chemblId}")
    public Ligand getLigand(@Parameter(description = "ChEMBL ID of ligand to be searched") 
    		@PathVariable(value="chemblId") String chemblId) {
    	
    	Ligand ligand = ligandService.findOneByChemblId(chemblId);

    	if(ligand == null) {
			throw new ResponseStatusException(
					  HttpStatus.NOT_FOUND, "entity not found"
					);
		}
    	
        return ligand; 
    }
    
    @Operation(summary = "Get a ligand by UUID", description = "Returns a single ligand", tags = { "ligand" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "successful operation",
                content = @Content(schema = @Schema(implementation = Ligand.class))),
        @ApiResponse(responseCode = "404", description = "Ligand not found",
        		content = @Content(schema = @Schema(implementation = ErrorPayload.class))) })
    @GetMapping("/api/v1/ligand/uuid/{ligandUuid}")
    public Ligand getLigandByUuid(@Parameter(description = "ChEMBL ID of ligand to be searched") 
    		@PathVariable(value="ligandUuid") String ligandUuid) {
    	
    	Ligand ligand = ligandService.findOneByLigandUuid(ligandUuid);

    	if(ligand == null) {
			throw new ResponseStatusException(
					  HttpStatus.NOT_FOUND, "entity not found"
					);
		}
    	
        return ligand;         
    }
    
    @Operation(summary = "Get a protein-ligand docking by mutant protein ID and ligand ChEMBL ID", description = "Returns a single protein-ligand", tags = { "protein-ligand" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "successful operation",
                content = @Content(schema = @Schema(implementation = MutatedProteinLigand.class))),
        @ApiResponse(responseCode = "404", description = "Ligand not found", 
        		content = @Content(schema = @Schema(implementation = ErrorPayload.class))) })    
    @GetMapping("/api/v1/variant/{variantId}/ligand/{ligandId}")
    public MutatedProteinLigand getVariantLigandComplex(@Parameter(description = "ID of mutant protein to be searched") 
    		@PathVariable(value="variantId") String variantId,
    		@Parameter(description = "ChEMBL ID of ligand to be searched") 
    		@PathVariable(value="ligandId") String ligandId) {
    	
    	MutatedProteinLigand docking = mutatedProteinLigandService.findOneById(
				new MutatedProteinLigandId(Long.parseLong(variantId), ligandId));

    	if(docking == null) {
			throw new ResponseStatusException(
					  HttpStatus.NOT_FOUND, "entity not found"
					);
		}
    	
        return docking;         
    }

    @Operation(summary = "Get a protein-ligand docking by protein-ligand UUID", description = "Returns a single protein-ligand", tags = { "protein-ligand" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "successful operation",
                content = @Content(schema = @Schema(implementation = MutatedProteinLigand.class))),
        @ApiResponse(responseCode = "404", description = "Ligand not found",
        		content = @Content(schema = @Schema(implementation = ErrorPayload.class))) })   
    @GetMapping("/api/v1/docking/{variantLigandUuid}")
    public MutatedProteinLigand getVariantLigandComplex(@Parameter(description = "UUID of protein-ligand docking to be searched") 
    		@PathVariable(value="variantLigandUuid") String variantLigandUuid) {
    	
    	MutatedProteinLigand docking = mutatedProteinLigandService.findOneByVariantLigandUuid(variantLigandUuid);

    	if(docking == null) {
			throw new ResponseStatusException(
					  HttpStatus.NOT_FOUND, "entity not found"
					);
		}
    	
        return docking;  
        
    }
    
    @GetMapping("/error")
    public ErrorPayload error() {
        return new ErrorPayload(
        		Instant.now().getEpochSecond(), 
        		404, 
        		"Not Found", 
        		"Entity not found",null);
    }
}

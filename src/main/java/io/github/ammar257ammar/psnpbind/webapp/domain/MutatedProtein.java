package io.github.ammar257ammar.psnpbind.webapp.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "psnpbind_variant")
public class MutatedProtein {
	
    @Schema(description = "Mutant protein's ID.", 
            example = "10", required = true)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "variant_id")
	private Long variantId;

    @Schema(description = "Mutant protein's globally unique identifier (generated from mutant protein's ID using UUID v3 algorithm).", 
            example = "P18031", required = true)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(length = 255, nullable = false, name="variant_uuid")
	private String variantUuid;
    
    @Schema(description = "Mutant protein's dockings folder name (needed to load the PDB file of the protein)", 
            example = "118", required = true)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(length = 50, nullable = false, name="variant_folder")
	private String variantFolder;
        
    @Schema(description = "Protein mutation type (Syntax: source AA, chain letter, AA position, target AA)", 
            example = "TA267A", required = true)
	@NotNull
    @Size(min = 1, max = 20)
    @Column(length = 20, nullable = false, name="variant_type")
	private String variantType;
	
    @Schema(description = "Protein mutation source amino acid (one letter encoding)", 
            example = "T", required = true)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(length = 20, nullable = false, name="source_aa")
	private String sourceAminoAcid;
    
    @Schema(description = "Protein mutation target amino acid (one letter encoding).", 
            example = "A", required = true)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(length = 20, nullable = false, name="target_aa")
	private String targetAminoAcid;

    @Schema(description = "mutation location (residue number in the PDB).", 
            example = "267", required = true)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(length = 20, nullable = false, name="residue_num")
	private String residueNumber;
    
    @Schema(description = "The chain where the mutation occured.", 
            example = "A", required = true)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(length = 20, nullable = false, name="chain")
	private String chain;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pdb_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Protein protein;
        
    @OneToMany(mappedBy = "vlVariant",
    		cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    @JsonIgnore
    Set<MutatedProteinLigand> variantLigands;
    
	public Long getVariantId() {
		return variantId;
	}

	public void setVariantId(Long variantId) {
		this.variantId = variantId;
	}

	public String getVariantUuid() {
		return variantUuid;
	}

	public void setVariantUuid(String variantUuid) {
		this.variantUuid = variantUuid;
	}

	public String getVariantFolder() {
		return variantFolder;
	}

	public void setVariantFolder(String variantFolder) {
		this.variantFolder = variantFolder;
	}

	public String getVariantType() {
		return variantType;
	}

	public void setVariantType(String variantType) {
		this.variantType = variantType;
	}

	public String getSourceAminoAcid() {
		return sourceAminoAcid;
	}

	public void setSourceAminoAcid(String sourceAminoAcid) {
		this.sourceAminoAcid = sourceAminoAcid;
	}

	public String getTargetAminoAcid() {
		return targetAminoAcid;
	}

	public void setTargetAminoAcid(String targetAminoAcid) {
		this.targetAminoAcid = targetAminoAcid;
	}

	public String getResidueNumber() {
		return residueNumber;
	}

	public void setResidueNumber(String residueNumber) {
		this.residueNumber = residueNumber;
	}

	public String getChain() {
		return chain;
	}

	public void setChain(String chain) {
		this.chain = chain;
	}

	public Protein getProtein() {
		return protein;
	}

	public void setProtein(Protein protein) {
		this.protein = protein;
	}

	public Set<MutatedProteinLigand> getVariantLigands() {
		return variantLigands;
	}

	public void setVariantLigands(Set<MutatedProteinLigand> variantLigands) {
		this.variantLigands = variantLigands;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((variantUuid == null) ? 0 : variantUuid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MutatedProtein other = (MutatedProtein) obj;
		if (variantUuid == null) {
			if (other.variantUuid != null)
				return false;
		} else if (!variantUuid.equals(other.variantUuid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MutatedProtein [variantId=" + variantId + ", variantUuid=" + variantUuid + ", variantFolder="
				+ variantFolder + ", variantType=" + variantType + ", sourceAminoAcid=" + sourceAminoAcid
				+ ", targetAminoAcid=" + targetAminoAcid + ", residueNumber=" + residueNumber + ", chain=" + chain + "]";
	}
	
}

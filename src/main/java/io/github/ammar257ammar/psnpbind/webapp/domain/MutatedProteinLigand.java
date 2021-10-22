package io.github.ammar257ammar.psnpbind.webapp.domain;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "psnpbind_variant_ligand")
public class MutatedProteinLigand {
	
	@EmbeddedId
    private MutatedProteinLigandId id;
 
    @Schema(description = "protein-ligand docking's globally unique identifier.", 
            example = "046eb7e1-808a-3542-a957-1bb99740049c", required = true)
    @NotNull
	@Column(length = 255, nullable = false, name = "variant_ligand_uuid")
	private String variantLigandUuid;
    
	@ManyToOne(fetch = FetchType.LAZY)
    @MapsId("variantId")
	@JoinColumn(name = "variant_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private MutatedProtein vlVariant;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @MapsId("chemblId")
	@JoinColumn(name = "chembl_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Ligand vlLigand;

    @Schema(description = "Mutant protein's dockings folder name (needed to load the PDB file of the protein).", 
            example = "118", required = true)
    @NotNull
	@Column(length = 50, nullable = false, name = "variant_folder")
	private String variantFolder;
	
    @Schema(description = "protein-ligand docking conformations folder name (needed to load the ligand's conformations file).", 
            example = "288", required = true)
    @NotNull
	@Column(length = 50, nullable = false, name = "ligand_folder")
	private String ligandFolder;

    @Schema(description = "Tanimoto similarity obtained from the comparison of the FP2 fingerprint of the ligand with the one in the experimentally obtained complex structure, calculated using OpenBabel", 
        example = "288", required = true)    
    @NotNull
    @Column(length = 50, nullable = false, name = "tanimoto_similarity")
    private String tanimotoSimilarity;

    @Schema(description = "protein-ligand docking calculated binding affinities for up to 3 conformers spearated by semi-colon (unit: kcal/mol).", 
            example = "Conformer 1: -7.0;Conformer 2: -6.8;Conformer 3: -6.5", required = true)
    @NotNull
	@Column(length = 512, nullable = false, name = "binding_affinity")
	private String bindingAffinity;

	public MutatedProteinLigandId getId() {
		return id;
	}

	public void setId(MutatedProteinLigandId id) {
		this.id = id;
	}

	public String getVariantLigandUuid() {
		return variantLigandUuid;
	}

	public void setVariantLigandUuid(String variantLigandUuid) {
		this.variantLigandUuid = variantLigandUuid;
	}

	public MutatedProtein getVlVariant() {
		return vlVariant;
	}

	public void setVlVariant(MutatedProtein vlVariant) {
		this.vlVariant = vlVariant;
	}

	public Ligand getVlLigand() {
		return vlLigand;
	}

	public void setVlLigand(Ligand vlLigand) {
		this.vlLigand = vlLigand;
	}

	public String getVariantFolder() {
		return variantFolder;
	}

	public void setVariantFolder(String variantFolder) {
		this.variantFolder = variantFolder;
	}

	public String getLigandFolder() {
		return ligandFolder;
	}

	public void setLigandFolder(String ligandFolder) {
		this.ligandFolder = ligandFolder;
	}
	
	public String getTanimotoSimilarity() {
        return tanimotoSimilarity;
    }

    public void setTanimotoSimilarity(String tanimotoSimilarity) {
        this.tanimotoSimilarity = tanimotoSimilarity;
    }

  public String getBindingAffinity() {
		return bindingAffinity;
	}

	public void setBindingAffinity(String bindingAffinity) {
		this.bindingAffinity = bindingAffinity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((variantLigandUuid == null) ? 0 : variantLigandUuid.hashCode());
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
		MutatedProteinLigand other = (MutatedProteinLigand) obj;
		if (variantLigandUuid == null) {
			if (other.variantLigandUuid != null)
				return false;
		} else if (!variantLigandUuid.equals(other.variantLigandUuid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MutatedProteinLigand [id=" + id + ", variantLigandUuid=" + variantLigandUuid
				+ ", variantFolder=" + variantFolder + ", ligandFolder="
				+ ligandFolder + ", bindingAffinity=" + bindingAffinity + "]";
	}
}

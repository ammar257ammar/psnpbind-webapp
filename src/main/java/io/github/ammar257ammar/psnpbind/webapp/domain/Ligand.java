package io.github.ammar257ammar.psnpbind.webapp.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "psnpbind_ligand")
public class Ligand {
 
    @Schema(description = "Ligand ChEMBL ID.", 
            example = "CHEMBL100128", required = true)
	@Id
    @NotNull
    @Size(min = 1, max = 50)
    @Column(length = 50, nullable = false, name="chembl_id")
	private String chemblId;

    @Schema(description = "Ligand's globally unique identifier (generated from ChEMBL ID using UUID v3 algorithm).", 
            example = "37eee8b7-c76f-3b3b-943e-cc0e224c0493", required = true)
    @NotNull
    @Column(nullable = false, name="ligand_uuid")
	private String ligandUuid;
    
    @Schema(description = "Ligand SMILES.", 
            example = "c12c(N)cccc1nccc2", required = true)
    @NotNull
    @Column(nullable = false, name="ligand_smiles")
	private String ligandSmiles;
    
    @Schema(description = "Number of rotatable bonds.", 
            example = "5", required = true)
    @NotNull
    @Column(nullable = false, name="rotatble_bonds")
	private String rotatbleBonds;
    
    @Schema(description = "Number of Hydrogen donors.", 
            example = "2", required = true)
    @NotNull
    @Column(nullable = false, name="hydrogen_donors")
	private String hydrogenDonors;
    
    @Schema(description = "Number of Hydrogen acceptors.", 
            example = "3", required = true)
    @NotNull
    @Column(nullable = false, name="hydrogen_acceptors")
	private String hydrogenAcceptors;
    
    @Schema(description = "Ligand's molecular weight (unit: Da).", 
            example = "261.4", required = true)
    @NotNull
    @Column(nullable = false, name="molecular_weight")
	private String molecularWeight;
    
    @Schema(description = "Ligand's XLogP descriptor (calculated using CDK v2.3 library's XLogPDescriptor class).", 
            example = "P18031", required = true)
    @NotNull
    @Column(nullable = false, name="xlogp")
	private String xlogp;
    
    @OneToMany(mappedBy = "plLigand",
    		cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    @JsonIgnore
    Set<ProteinLigand> ligandProteins;

    @OneToMany(mappedBy = "vlLigand",
    		cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    @JsonIgnore
    Set<MutatedProteinLigand> ligandVariants;
    
	public String getChemblId() {
		return chemblId;
	}

	public void setChemblId(String chemblId) {
		this.chemblId = chemblId;
	}

	public String getLigandUuid() {
		return ligandUuid;
	}

	public void setLigandUuid(String ligandUuid) {
		this.ligandUuid = ligandUuid;
	}

	public String getLigandSmiles() {
		return ligandSmiles;
	}

	public void setLigandSmiles(String ligandSmiles) {
		this.ligandSmiles = ligandSmiles;
	}

	public String getRotatbleBonds() {
		return rotatbleBonds;
	}

	public void setRotatbleBonds(String rotatbleBonds) {
		this.rotatbleBonds = rotatbleBonds;
	}

	public String getHydrogenDonors() {
		return hydrogenDonors;
	}

	public void setHydrogenDonors(String hydrogenDonors) {
		this.hydrogenDonors = hydrogenDonors;
	}

	public String getHydrogenAcceptors() {
		return hydrogenAcceptors;
	}

	public void setHydrogenAcceptors(String hydrogenAcceptors) {
		this.hydrogenAcceptors = hydrogenAcceptors;
	}

	public String getMolecularWeight() {
		return molecularWeight;
	}

	public void setMolecularWeight(String molecularWeight) {
		this.molecularWeight = molecularWeight;
	}

	public String getXlogp() {
		return xlogp;
	}

	public void setXlogp(String xlogp) {
		this.xlogp = xlogp;
	}

	public Set<ProteinLigand> getLigandProteins() {
		return ligandProteins;
	}

	public void setLigandProteins(Set<ProteinLigand> ligandProteins) {
		this.ligandProteins = ligandProteins;
	}

	public Set<MutatedProteinLigand> getLigandVariants() {
		return ligandVariants;
	}

	public void setLigandVariants(Set<MutatedProteinLigand> ligandVariants) {
		this.ligandVariants = ligandVariants;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chemblId == null) ? 0 : chemblId.hashCode());
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
		Ligand other = (Ligand) obj;
		if (chemblId == null) {
			if (other.chemblId != null)
				return false;
		} else if (!chemblId.equals(other.chemblId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ligand [chemblId=" + chemblId + ", ligandUuid=" + ligandUuid + ", ligandSmiles=" + ligandSmiles
				+ ", rotatbleBonds=" + rotatbleBonds + ", hydrogenDonors=" + hydrogenDonors + ", hydrogenAcceptors="
				+ hydrogenAcceptors + ", molecularWeight=" + molecularWeight + ", xlogp=" + xlogp + "]";
	}
}

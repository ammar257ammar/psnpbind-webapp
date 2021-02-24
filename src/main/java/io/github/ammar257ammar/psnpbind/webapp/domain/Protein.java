package io.github.ammar257ammar.psnpbind.webapp.domain;

import java.sql.Date;
import java.util.HashSet;
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
@Table(name = "psnpbind_protein")
public class Protein {
	
    @Schema(description = "Protein PDB identifier (Unique ID).", 
            example = "2hb1", required = true)
    @Id
    @NotNull
    @Size(min = 1, max = 4)
    @Column(length = 4, nullable = false, name="pdb_id")
	private String pdbId;

    @Schema(description = "Protein's globally unique identifier (generated from PDB ID using UUID v3 algorithm).", 
            example = "4bd4c14e-7b2c-30b0-a910-8a890fed3758", required = true)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(length = 255, nullable = false, name="protein_uuid")
	private String proteinUuid;
    
    @Schema(description = "Protein name.", 
            example = "Tyrosine-protein phosphatase non-receptor type 1 (E.C.3.1.3.48)", required = true)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(length = 255, nullable = false, name="protein_name")
	private String proteinName;

    @Schema(description = "Protein's Uniprot ID.", 
            example = "P18031", required = true)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(length = 20, nullable = false, name="uniprot_id")
	private String uniprotId;

    @Schema(description = "Experimental method used to obtain the protein's structure.", 
            example = "X-ray", required = true)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(length = 255, nullable = false, name="experimental_method")
	private String experimentalMethod;

    @Schema(description = "PDB structure resolution.", 
            example = "1.9", required = true)
    @NotNull
    @Column(nullable = false, name="pdb_resolution")
	private double pdbResolution;
	
    @Schema(description = "PDB structure deposit date in Protein Data Bank", 
            example = "2003-03-28 00:00:00", required = true)
    @NotNull
    @Column(nullable = false, name="deposit_date")
	private Date depositDate;
	
    @Schema(description = "PDB structure revision date in Protein Data Bank", 
            example = "2003-03-28 00:00:00", required = true)
    @NotNull
    @Column(nullable = false, name="revision_date")
	private Date revisionDate;

    @Schema(description = "Protein's number of chains.", 
            example = "2", required = true)
    @NotNull
    @Column(nullable = false, name="number_of_chains")
	private int numberOfChains;
	
    @Schema(description = "Protein's sequence length.", 
            example = "439", required = true)
    @NotNull
    @Column(nullable = false, name="sequence_length")
	private int sequenceLength;
	
    @Schema(description = "Protein's molecular weight (unit: kDa).", 
            example = "35.11", required = true)
    @NotNull
    @Column(nullable = false, name="molecular_weight")
	private double molecularWeight;
	
    @Schema(description = "Protein's atom count.", 
            example = "2611", required = true)
    @NotNull
    @Column(nullable = false, name="atom_count")
	private int atomCount;
    
    @OneToMany(cascade = CascadeType.ALL, 
    		   orphanRemoval = true, 
    		   mappedBy = "protein",
    		   fetch = FetchType.LAZY
    		  )
    @JsonIgnore    
    private Set<MutatedProtein> variants = new HashSet<>();
        
    @OneToMany(mappedBy = "plProtein",
    		   fetch = FetchType.LAZY
    		  )
    @JsonIgnore
    Set<ProteinLigand> proteinLigands;

	public String getPdbId() {
		return pdbId;
	}

	public void setPdbId(String pdbId) {
		this.pdbId = pdbId;
	}

	public String getProteinUuid() {
		return proteinUuid;
	}

	public void setProteinUuid(String proteinUuid) {
		this.proteinUuid = proteinUuid;
	}

	public String getProteinName() {
		return proteinName;
	}

	public void setProteinName(String proteinName) {
		this.proteinName = proteinName;
	}

	public String getUniprotId() {
		return uniprotId;
	}

	public void setUniprotId(String uniprotId) {
		this.uniprotId = uniprotId;
	}

	public String getExperimentalMethod() {
		return experimentalMethod;
	}

	public void setExperimentalMethod(String experimentalMethod) {
		this.experimentalMethod = experimentalMethod;
	}

	public double getPdbResolution() {
		return pdbResolution;
	}

	public void setPdbResolution(double pdbResolution) {
		this.pdbResolution = pdbResolution;
	}

	public Date getDepositDate() {
		return depositDate;
	}

	public void setDepositDate(Date depositDate) {
		this.depositDate = depositDate;
	}

	public Date getRevisionDate() {
		return revisionDate;
	}

	public void setRevisionDate(Date revisionDate) {
		this.revisionDate = revisionDate;
	}

	public int getNumberOfChains() {
		return numberOfChains;
	}

	public void setNumberOfChains(int numberOfChains) {
		this.numberOfChains = numberOfChains;
	}

	public int getSequenceLength() {
		return sequenceLength;
	}

	public void setSequenceLength(int sequenceLength) {
		this.sequenceLength = sequenceLength;
	}

	public double getMolecularWeight() {
		return molecularWeight;
	}

	public void setMolecularWeight(double molecularWeight) {
		this.molecularWeight = molecularWeight;
	}

	public int getAtomCount() {
		return atomCount;
	}

	public void setAtomCount(int atomCount) {
		this.atomCount = atomCount;
	}

	public Set<MutatedProtein> getVariants() {
		return variants;
	}

	public void setVariants(Set<MutatedProtein> variants) {
		this.variants = variants;
	}

	public Set<ProteinLigand> getProteinLigands() {
		return proteinLigands;
	}

	public void setProteinLigands(Set<ProteinLigand> proteinLigands) {
		this.proteinLigands = proteinLigands;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((proteinUuid == null) ? 0 : proteinUuid.hashCode());
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
		Protein other = (Protein) obj;
		if (proteinUuid == null) {
			if (other.proteinUuid != null)
				return false;
		} else if (!proteinUuid.equals(other.proteinUuid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Protein [pdbId=" + pdbId + ", proteinUUID=" + proteinUuid + ", proteinName=" + proteinName
				+ ", uniprotId=" + uniprotId + ", experimentalMethod=" + experimentalMethod + ", pdbResolution="
				+ pdbResolution + ", depositDate=" + depositDate + ", revisionDate=" + revisionDate
				+ ", numberOfChains=" + numberOfChains + ", sequenceLength=" + sequenceLength + ", molecularWeight="
				+ molecularWeight + ", atomCount=" + atomCount + "]";
	}
}

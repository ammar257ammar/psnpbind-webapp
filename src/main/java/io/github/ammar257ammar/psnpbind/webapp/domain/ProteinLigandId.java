package io.github.ammar257ammar.psnpbind.webapp.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ProteinLigandId implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(name = "pdb_id")
    private String pdbId;
 
    @Column(name = "chembl_id")
    private String chemblId;
    
	public ProteinLigandId() {
	}

	public ProteinLigandId(String pdbId, String chemblId) {
		super();
		this.pdbId = pdbId;
		this.chemblId = chemblId;
	}

	public String getPdbId() {
		return pdbId;
	}

	public void setPdbId(String pdbId) {
		this.pdbId = pdbId;
	}

	public String getChemblId() {
		return chemblId;
	}

	public void setChemblId(String chemblId) {
		this.chemblId = chemblId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result1 = 1;
		int result2 = 1;
		result1 = prime * result1 + ((chemblId == null) ? 0 : chemblId.hashCode());
		result2 = prime * result2 + ((pdbId == null) ? 0 : pdbId.hashCode());
		return result1 * result2;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProteinLigandId other = (ProteinLigandId) obj;
		if (chemblId == null) {
			if (other.chemblId != null)
				return false;
		} else if (!chemblId.equals(other.chemblId))
			return false;
		if (pdbId == null) {
			if (other.pdbId != null)
				return false;
		} else if (!pdbId.equals(other.pdbId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProteinLigandId [pdbId=" + pdbId + ", chemblId=" + chemblId + "]";
	}
}

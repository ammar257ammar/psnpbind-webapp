package io.github.ammar257ammar.psnpbind.webapp.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MutatedProteinLigandId implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Column(name = "variant_id")
    private Long variantId;
 
    @Column(name = "chembl_id")
    private String chemblId;

	public MutatedProteinLigandId() {}

	public MutatedProteinLigandId(Long variantId, String chemblId) {
		super();
		this.variantId = variantId;
		this.chemblId = chemblId;
	}

	public Long getVariantId() {
		return variantId;
	}

	public void setVariantId(Long variantId) {
		this.variantId = variantId;
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
		result2 = prime * result2 + ((variantId == null) ? 0 : variantId.hashCode());
		return result1*result2;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MutatedProteinLigandId other = (MutatedProteinLigandId) obj;
		if (chemblId == null) {
			if (other.chemblId != null)
				return false;
		} else if (!chemblId.equals(other.chemblId))
			return false;
		if (variantId == null) {
			if (other.variantId != null)
				return false;
		} else if (!variantId.equals(other.variantId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MutatedProteinLigandId [variantId=" + variantId + ", chemblId=" + chemblId + "]";
	}
}

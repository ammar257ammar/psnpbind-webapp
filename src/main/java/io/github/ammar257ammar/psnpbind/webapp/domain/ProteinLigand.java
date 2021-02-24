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

@Entity
@Table(name = "psnpbind_protein_ligand")
public class ProteinLigand {
	
	@EmbeddedId
    private ProteinLigandId id;
 
	@ManyToOne(fetch = FetchType.LAZY)
    @MapsId("pdbId")
	@JoinColumn(name = "pdb_id")
	private Protein plProtein;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @MapsId("chemblId")
	@JoinColumn(name = "chembl_id")
    private Ligand plLigand;
	
    @NotNull
	@Column(length = 50, nullable = false, name = "ligand_folder")
	private String ligandFolder;

	public ProteinLigandId getId() {
		return id;
	}

	public void setId(ProteinLigandId id) {
		this.id = id;
	}

	public Protein getProtein() {
		return plProtein;
	}

	public void setProtein(Protein protein) {
		this.plProtein = protein;
	}

	public Ligand getLigand() {
		return plLigand;
	}

	public void setLigand(Ligand ligand) {
		this.plLigand = ligand;
	}

	public String getLigandFolder() {
		return ligandFolder;
	}

	public void setLigandFolder(String ligandFolder) {
		this.ligandFolder = ligandFolder;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		ProteinLigand other = (ProteinLigand) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProteinLigand [id=" + id + ", ligandFolder=" + ligandFolder + "]";
	}
}

package io.github.ammar257ammar.psnpbind.webapp.jsonld;

import ioinformarics.oss.jackson.module.jsonld.annotation.JsonldId;
import ioinformarics.oss.jackson.module.jsonld.annotation.JsonldNamespace;
import ioinformarics.oss.jackson.module.jsonld.annotation.JsonldProperty;
import ioinformarics.oss.jackson.module.jsonld.annotation.JsonldResource;
import ioinformarics.oss.jackson.module.jsonld.annotation.JsonldType;

@JsonldResource
@JsonldNamespace(name = "bs", uri = "https://bioschemas.org/")
@JsonldType("bs:Protein")
public class ProteinJsonLd {
	
	@JsonldId
	@JsonldProperty("https://schema.org/identifier")
	private String pdbId;

	@JsonldProperty("https://schema.org/url")
	private String pdbUrl;
	
	@JsonldProperty("https://schema.org/name")
	private String proteinName;

	@JsonldProperty("https://schema.org/identifier")
	private String uniprotId;
	
	@JsonldProperty("bs:taxonomicRange")
	private String taxon;

	@JsonldProperty("https://schema.org/image")
	private String image;

	@JsonldProperty("bs:hasRepresentation")
	private String sequence;

	@JsonldProperty("http://purl.org/dc/terms/conformsTo")
	private String conformsTo;

	public String getPdbId() {
		return pdbId;
	}

	public void setPdbId(String pdbId) {
		this.pdbId = pdbId;
	}

	public String getPdbUrl() {
		return pdbUrl;
	}

	public void setPdbUrl(String pdbUrl) {
		this.pdbUrl = pdbUrl;
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

	public String getTaxon() {
		return taxon;
	}

	public void setTaxon(String taxon) {
		this.taxon = taxon;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}

	public String getConformsTo() {
		return conformsTo;
	}

	public void setConformsTo(String conformsTo) {
		this.conformsTo = conformsTo;
	}

	public ProteinJsonLd(String pdbId, String proteinName, String uniprotId) {
		this.pdbId = pdbId;
		this.pdbUrl = "https://www.rcsb.org/structure/"+pdbId;
		this.proteinName = proteinName;
		this.uniprotId = uniprotId;
		this.taxon = "https://www.ncbi.nlm.nih.gov/taxonomy/9606";
		this.image = "http://cdn.rcsb.org/images/structures/"+pdbId.substring(1, 3)+"/"+pdbId+"/"+pdbId+"_assembly-1.jpeg";
		this.sequence = "https://www.uniprot.org/uniprot/"+uniprotId+".fasta";
		this.conformsTo = "https://bioschemas.org/profiles/Protein/0.11-RELEASE";
	}
	
}

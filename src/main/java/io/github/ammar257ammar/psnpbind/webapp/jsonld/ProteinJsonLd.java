package io.github.ammar257ammar.psnpbind.webapp.jsonld;

import ioinformarics.oss.jackson.module.jsonld.annotation.JsonldId;
import ioinformarics.oss.jackson.module.jsonld.annotation.JsonldProperty;
import ioinformarics.oss.jackson.module.jsonld.annotation.JsonldResource;
import ioinformarics.oss.jackson.module.jsonld.annotation.JsonldType;

@JsonldResource
@JsonldType("https://schema.org/Protein")
public class ProteinJsonLd {
	
	@JsonldId
	private String psnpbindJsonldId;
	
	@JsonldProperty("https://schema.org/identifier")
	private String psnpbindIdentifier;

	@JsonldProperty("https://schema.org/url")
	private String psnpbindUrl;
	
	@JsonldProperty("https://schema.org/name")
	private String proteinName;

	@JsonldProperty("https://schema.org/sameAs")
	private String sameAsUniprotId;

	@JsonldProperty("https://schema.org/sameAs")
	private String sameAsPdbId;
	
	@JsonldProperty("https://schema.org/taxonomicRange")
	private String taxon;

	@JsonldProperty("https://schema.org/image")
	private String image;

	@JsonldProperty("https://schema.org/hasRepresentation")
	private String sequence;

	@JsonldProperty("http://purl.org/dc/terms/conformsTo")
	private String conformsTo;


	public String getPsnpbindJsonldId() {
		return psnpbindJsonldId;
	}

	public void setPsnpbindJsonldId(String psnpbindJsonldId) {
		this.psnpbindJsonldId = psnpbindJsonldId;
	}

	public String getPsnpbindIdentifier() {
		return psnpbindIdentifier;
	}

	public void setPsnpbindIdentifier(String psnpbindIdentifier) {
		this.psnpbindIdentifier = psnpbindIdentifier;
	}

	public String getSameAsUniprotId() {
		return sameAsUniprotId;
	}

	public void setSameAsUniprotId(String sameAsUniprotId) {
		this.sameAsUniprotId = sameAsUniprotId;
	}

	public String getSameAsPdbId() {
		return sameAsPdbId;
	}

	public void setSameAsPdbId(String sameAsPdbId) {
		this.sameAsPdbId = sameAsPdbId;
	}

	public String getPsnpbindUrl() {
		return psnpbindUrl;
	}

	public void setPsnpbindUrl(String psnpbindUrl) {
		this.psnpbindUrl = psnpbindUrl;
	}

	public String getProteinName() {
		return proteinName;
	}

	public void setProteinName(String proteinName) {
		this.proteinName = proteinName;
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

	public ProteinJsonLd(String pdbId, String proteinUuid, String proteinName, String uniprotId) {
		this.psnpbindJsonldId = "https://w3id.org/psnpbind/protein/"+pdbId;
		this.psnpbindIdentifier = "https://w3id.org/psnpbind/protein/"+pdbId;
		this.psnpbindUrl = "https://psnpbind.org/protein/"+pdbId;
		this.proteinName = proteinName;
		this.sameAsPdbId = "https://www.rcsb.org/structure/"+pdbId;
		this.sameAsUniprotId = "https://www.uniprot.org/uniprot/"+uniprotId;
		this.taxon = "https://www.ncbi.nlm.nih.gov/taxonomy/9606";
		this.image = "http://cdn.rcsb.org/images/structures/"+pdbId.substring(1, 3)+"/"+pdbId+"/"+pdbId+"_assembly-1.jpeg";
		this.sequence = "https://www.uniprot.org/uniprot/"+uniprotId+".fasta";
		this.conformsTo = "https://bioschemas.org/profiles/Protein/0.11-RELEASE";
	}
	
}

<#include "/fragments/head.ftl">

	<style>
		.nav-item a{
			color: white !important;
		}
		
		.view{
			background-color: black;
			height: 100px;
		}
				
		.features-area {
			padding-top: 20px;
		}
		
		.ligands tr td{
			vertical-align: middle;
			text-align: center;
		}
		
		.ligands tr td img{
			width: 150px;
		}
		
		.table-title{
			padding-top: 35px;
			padding-bottom: 35px;
		}
		
		.variant-table{
			height: 500px;
		}
		
		.variant-table td{
			vertical-align: middle;
		}
	</style>
	
<#include "/fragments/navbar.ftl">
    
	<section id="home" class="slider_area">
        
        <div class="view">
			
		</div>
    </section>
	
    <section id="services" class="features-area">
        <div class="container">
        	<script type="application/ld+json">
        		${proteinJsonLd}
			</script>
            <div class="row justify-content-center">
                <div class="col-lg-6 col-md-10">
                    <div class="section-title text-center pb-10">
                        <h4 class="table-title">${protein.proteinName}</h4>
					</div> <!-- row -->
                </div>
            </div> <!-- row -->
            <div class="row justify-content-center">
				<div class="col-md-6 col-sm-12">
					<img src="http://cdn.rcsb.org/images/structures/${protein.pdbId?string[1..2]}/${protein.pdbId}/${protein.pdbId}_assembly-1.jpeg" class="card-img-top img-responsive" alt="${protein.pdbId}">
				</div>
				<div class="col-md-6 col-sm-12">
					<table class="table">
						<tr>
							<td><p class="font-weight-bold">GUID</p></td>
							<td><a href="https://w3id.org/psnpbind/protein/${protein.pdbId}" target="_blank">https://w3id.org/psnpbind/protein/${protein.pdbId}</a></td>
						</tr>
						<tr>
							<td><p class="font-weight-bold">PDB ID</p></td>
							<td><a href="https://www.rcsb.org/structure/${protein.pdbId}" target="_blank">${protein.pdbId}</a></td>
						</tr>
						<tr>
							<td><p class="font-weight-bold">UniProt ID</p></td>
							<td><a href="https://www.uniprot.org/uniprot/${protein.uniprotId}" target="_blank">${protein.uniprotId}</a>
								<small>(<a href="https://www.uniprot.org/uniprot/${protein.uniprotId}.fasta" target="_blank">Download sequence</a>)</small>
							</td>
						</tr>
						<tr>
							<td><p class="font-weight-bold">Experimental Method</p></td>
							<td>${protein.experimentalMethod}</td>
						</tr>
						<tr>
							<td><p class="font-weight-bold">PDB Resolution</p></td>
							<td>${protein.pdbResolution}</td>
						</tr>
						<tr>
							<td><p class="font-weight-bold">Deposit Date</p></td>
							<td>${protein.depositDate}</td>
						</tr>
						<tr>
							<td><p class="font-weight-bold">Revision Date</p></td>
							<td>${protein.revisionDate}</td>
						</tr>
						<tr>
							<td><p class="font-weight-bold">Number of Chains</p></td>
							<td>${protein.numberOfChains}</td>
						</tr>
						<tr>
							<td><p class="font-weight-bold">Sequence Length</p></td>
							<td>${protein.sequenceLength}</td>
						</tr>
						<tr>
							<td><p class="font-weight-bold">Molecular Weight</p></td>
							<td>${protein.molecularWeight}</td>
						</tr>
						<tr>
							<td><p class="font-weight-bold">Atom Count</p></td>
							<td>${protein.atomCount}</td>
						</tr>
					</table>
				</div>
            </div> <!-- row -->
			</hr>
			
			<div class="row justify-content-center">
				<div class="col-md-12">
					<h4 class="table-title">Protein variants</h4>
				</div>			
			</div>
			
			<div class="row justify-content-center">
				<div class="col-md-12">
					<table class="table table-striped">
					
						<thead>
							<td><p class="font-weight-bold">Variant type</p></td>
							<td><p class="font-weight-bold">Source AA</p></td>
							<td><p class="font-weight-bold">Target AA</p></td>
							<td><p class="font-weight-bold">Residue number</p></td>
							<td><p class="font-weight-bold">Chain</p></td>
							<td></td>
						</thead>
					
						<#list protein.variants as variant>
							
							<tr>
								<td>${variant.variantType}</td>
								<td>${variant.sourceAminoAcid}</td>
								<td>${variant.targetAminoAcid}</td>
								<td>${variant.residueNumber}</td>
								<td>${variant.chain}</td>
								<td><a href="/variant/${variant.variantId}" role="button" class="btn btn-secondary">Variant Details</a></td>
							</tr>
						
						</#list>
					</table>
				</div>			
			</div>
        </div> <!-- container -->
    </section>
	
<#include "/fragments/footer.ftl">

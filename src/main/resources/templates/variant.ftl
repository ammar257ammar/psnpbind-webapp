<#include "/fragments/head.ftl">

	<script src="/js/JSmol.min.js"></script>

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
            <div class="row justify-content-center">
                <div class="col-lg-6 col-md-10">
                    <div class="section-title text-center pb-10">
                        <h4 class="table-title">Protein Variant (PDB ID: ${variant.protein.pdbId} - Variant: ${variant.variantType})</h4>
					</div> <!-- row -->
                </div>
            </div> <!-- row -->
            <!-- https://files.rcsb.org/download/${variant.protein.pdbId}.pdb -->
            <div class="row justify-content-center">
				<div class="col-md-6 col-sm-12">
					<script type="text/javascript">
						var InfoA = {
						  width: 500,
						  height: 500,
						  j2sPath: "/js/j2s"
						}
						jmolApplet = Jmol.getApplet("obie",InfoA);
						Jmol.script(obie,`load /files/${variant.protein.pdbId}/proteins/${variant.protein.pdbId}_protein_Repair_${variant.variantFolder}/${variant.protein.pdbId}_protein_Repair_${variant.variantFolder}_final.pdb;
										  delete water; 
										  select atomno=1;
										  label 'N';
										  lastatom={*}.size;
										  select {{*}[lastatom]}
										  label 'C';
										  colour labels yellow;
										  select all;
										  wireframe off;
										  spacefill off;
										  cartoon;
										  select ${variant.residueNumber};
										  cartoon off;
										  wireframe 0.5;
										  spacefill 0.5;
										  set specular on;
										  load append /files/${variant.protein.pdbId}_ligand_similar_2_min_docking.pdbqt;
										  display 1.1,2.1;`,"left");
					</script>				
				</div>
				<div class="col-md-6 col-sm-12">
					<table class="table variant-table">
						<tr>
							<td><p class="font-weight-bold">PBB ID</p></td>
							<td>${variant.protein.pdbId}</td>
						</tr>
						<tr>
							<td><p class="font-weight-bold">Variant Type</p></td>
							<td>${variant.variantType}</td>
						</tr>
						<tr>
							<td><p class="font-weight-bold">Source Amino Acid</p></td>
							<td>${variant.sourceAminoAcid}</td>
						</tr>
						<tr>
							<td><p class="font-weight-bold">Target Amino Acid</p></td>
							<td>${variant.targetAminoAcid}</td>
						</tr>
						<tr>
							<td><p class="font-weight-bold">Residue Number</p></td>
							<td>${variant.residueNumber}</td>
						</tr>
						<tr>
							<td><p class="font-weight-bold">Chain</p></td>
							<td>${variant.chain}</td>
						</tr>
					</table>
				</div>
            </div> <!-- row -->
			</hr>
			
			<div class="row justify-content-center">
				<div class="col-md-12">
					<h4 class="table-title">Ligands complexed with protein ${variant.protein.pdbId} (variant ${variant.variantType})</h4>
				</div>			
			</div>
			
			<div class="row justify-content-center">
				<div class="col-md-12">
					<table id="ligands" class="table table-striped ligands">
					
						<thead>
							<td><p class="font-weight-bold">ChEMBL ID</p></td>
							<td><p class="font-weight-bold">Molecule Depiction</p></td>
							<td><p class="font-weight-bold"># of Rotatble Bonds</p></td>
							<td><p class="font-weight-bold"># of Hydrogen Donors</p></td>
							<td><p class="font-weight-bold"># of Hydrogen Acceptors</p></td>
							<!--<td><p class="font-weight-bold">Molecular Weight</p></td>
							<td><p class="font-weight-bold">XLogP</p></td>-->
							<td></td>
						</thead>
					
						<#list variant.variantLigands as variantLigand>

							<tr>
								<td><a target="_blank" href="https://www.ebi.ac.uk/chembl/compound_report_card/${variantLigand.vlLigand.chemblId}">${variantLigand.vlLigand.chemblId}</a></td>
								<td><img id="Bck-COMP_IMG" class="compound-img" src="https://www.ebi.ac.uk/chembl/api/data/image/${variantLigand.vlLigand.chemblId}.svg" alt="Compound Image"></td>
								<td>${variantLigand.vlLigand.rotatbleBonds?if_exists}</td>
								<td>${variantLigand.vlLigand.hydrogenDonors?if_exists}</td>
								<td>${variantLigand.vlLigand.hydrogenAcceptors?if_exists}</td>
								
								<td><a href="/variant/${variant.variantId}/ligand/${variantLigand.vlLigand.chemblId}" role="button" class="btn btn-secondary">Complex Details</a></td>
							</tr>
						
						</#list>
					</table>
				</div>			
			</div>
        </div> <!-- container -->
    </section>

<#include "/fragments/footerExtended.ftl">
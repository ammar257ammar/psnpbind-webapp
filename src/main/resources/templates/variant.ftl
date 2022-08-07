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
										  set refreshing off;
										  if(antialiasDisplay);
										  antialiasDisplay = false;
										  cartoonFancy=false;
										  antialiasDisplayFlag = false;else;antialiasDisplay = true;
										  cartoonFancy=true;
										  antialiasDisplayFlag = true;
										  endif;
										  set refreshing on;refresh;`,"left");
						function superimpose(){
						  
						  Jmol.script(obie,`load append /files/${variant.protein.pdbId}/proteins/${variant.protein.pdbId}_protein_Repair_WT/${variant.protein.pdbId}_protein_Repair_WT_final.pdb;
                                                          compare {1.1} {2.1} SUBSET{*.CA} ATOMS{protein}{protein} ROTATE TRANSLATE 2.0;
                                                          select all; center selected;
                                                          cartoon only;
                                                          select 2.1; color orange;
                                                          display 1.1,2.1;
                                                          frame 0;
                                                          set refreshing off;
                                                          if(antialiasDisplay);
                                                          antialiasDisplay = false;
                                                          cartoonFancy=false;
                                                          antialiasDisplayFlag = false;else;antialiasDisplay = true;
                                                          cartoonFancy=true;
                                                          antialiasDisplayFlag = true;
                                                          endif;
                                                          set refreshing on;refresh;`,"left");
						}
					</script>				
				</div>
				<div class="col-md-6 col-sm-12">
					<table class="table variant-table">
						<tr>
							<td><p class="font-weight-bold">GUID</p></td>
							<td><a href="https://w3id.org/psnpbind/variant/${variant.variantId}" target="_blank">https://w3id.org/psnpbind/variant/${variant.variantId}</a></td>
						</tr>
						<tr>
							<td><p class="font-weight-bold">PDB ID</p></td>
							<td><a href="https://www.rcsb.org/structure/${variant.protein.pdbId}" target="_blank">${variant.protein.pdbId}</a></td>
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
						<tr>
						        <td colspan="2"><button class="btn btn-primary" onclick="superimpose()">Superimpose to wild-type protein</button></td>
						</tr>
                                                <tr>
                                                        <td colspan="2"><a class="btn btn-success" href="/files/${variant.protein.pdbId}/proteins/${variant.protein.pdbId}_protein_Repair_${variant.variantFolder}/${variant.protein.pdbId}_protein_Repair_${variant.variantFolder}_final.pdb">Download variant protein structure</a></td>
                                                </tr>
                                                <tr>
                                                        <td colspan="2"><a class="btn btn-success" href="/files/${variant.protein.pdbId}/proteins/${variant.protein.pdbId}_protein_Repair_WT/${variant.protein.pdbId}_protein_Repair_WT_final.pdb">Download wild-type protein structure</a></td>
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
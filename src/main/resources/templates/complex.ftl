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
                        <h4 class="table-title">Protein-ligand Complex: </br> Protein (PDB ID: ${vl.vlVariant.protein.pdbId} - Variant: ${vl.vlVariant.variantType}) </br> & Ligand (ChEMBL ID:  ${vl.vlLigand.chemblId})</h4>
					</div> <!-- row -->
                </div>
            </div> <!-- row -->
            <div class="row justify-content-center">
				<div class="col-md-6 col-sm-12">
					<script type="text/javascript">
						var InfoA = {
						  width: 500,
						  height: 500,
						  j2sPath: "/js/j2s"
						}
						jmolApplet = Jmol.getApplet("obie",InfoA);
						Jmol.script(obie,`load /files/${vl.vlVariant.protein.pdbId}/proteins/${vl.variantFolder}/${vl.variantFolder}_final.pdb;
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
										  select ${vl.vlVariant.residueNumber};
										  cartoon off;
										  wireframe 0.5;
										  spacefill 0.5;
										  set specular on;
										  load append /files/${vl.vlVariant.protein.pdbId}/proteins/${vl.variantFolder}/vina/${vl.ligandFolder}/${vl.ligandFolder}_min_docking.pdbqt;
										  display 1.1,2.1; frame 0;
										  set refreshing off;
                                                                                  if(antialiasDisplay);
                                                                                  antialiasDisplay = false;
                                                                                  cartoonFancy=false;
                                                                                  antialiasDisplayFlag = false;else;antialiasDisplay = true;
                                                                                  cartoonFancy=true;
                                                                                  antialiasDisplayFlag = true;
                                                                                  endif;
                                                                                  set refreshing on;refresh;`,"left");
					</script>
				</div>
				<div class="col-md-6 col-sm-12">
					<table class="table">
						<tr>
							<td><p class="font-weight-bold">GUID</p></td>
							<td><a href="https://w3id.org/psnpbind/variant/${vl.vlVariant.variantId}/ligand/${vl.vlLigand.chemblId}" target="_blank">https://w3id.org/psnpbind/variant/${vl.vlVariant.variantId}/ligand/${vl.vlLigand.chemblId}</a></td>
						</tr>
						<tr>
							<td><p class="font-weight-bold">PDB ID</p></td>
							<td><a href="https://www.rcsb.org/structure/${vl.vlVariant.protein.pdbId}" target="_blank">${vl.vlVariant.protein.pdbId}</a></td>
						</tr>
						<tr>
							<td><p class="font-weight-bold">Variant Type</p></td>
							<td>${vl.vlVariant.variantType}</td>
						</tr>
						<tr>
							<td><p class="font-weight-bold">Ligand ID (ChEMBL ID)</p></td>
							<td><a target="_blank" href="https://www.ebi.ac.uk/chembl/compound_report_card/${vl.vlLigand.chemblId}">${vl.vlLigand.chemblId}</a></td>
						</tr>
						<tr>
                                                        <td style="width:50%;"><p class="font-weight-bold">Ligand Similarity* to the one in the experimentally obtained structure of the <a href="https://www.rcsb.org/structure/${vl.vlVariant.protein.pdbId}" target="_blank">${vl.vlVariant.protein.pdbId}</a> complex</p>
                                                            <br><small>* Tanimoto similarity obtained from the comparison of the FP2 fingerprint of the ligands, calculated using OpenBabel</small>
                                                        </td>
                                                        <td>${vl.tanimotoSimilarity}</td>
                                                </tr>
						<tr>
							<td><p class="font-weight-bold">Binding Affinity</p></td>
							<td>
								<ul>
									<li><#list conformers as conformer>
									   ${conformer} Kcal/Mol </br>
									</#list></li>
								</ul>
							</td>
						</tr>
						<tr>
                                                        <td colspan="2"><p class="font-weight-bold">${listString}</p></td>
                                                </tr>
                                                <#list wtList as wtVl>
                                                <tr> 
                                                        <td><a target="_blank" href="/variant/${wtVl.vlVariant.variantId}/ligand/${vl.vlLigand.chemblId}">${wtVl.vlVariant.variantType}</a></td>
                                                        <td>${wtVl.bindingAffinity} Kcal/Mol</td>
                                                </tr>
                                                </#list>
					</table>
				</div>
            </div> <!-- row -->			
        </div> <!-- container -->
    </section>
	
<#include "/fragments/footer.ftl">
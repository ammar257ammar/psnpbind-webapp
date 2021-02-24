<#include "/fragments/head.ftl">
	
<#include "/fragments/navbar.ftl">
    
    <!-- Video background START -->

    <section id="home" class="slider_area">
        
        <div class="view">
			<!--Video source-->
			<video class="video-fluid" autoplay loop muted>
			  <source src="images/slider/video.mp4" type="video/mp4" />
			</video>
			<div class="mask rgba-indigo-light"></div>
		</div>
    </section>

    <!-- Video background ENDS -->

    <section id="services" class="features-area">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-6 col-md-10">
                    <div class="section-title text-center pb-10">
                        <h3 class="title">PSnpBind Proteins</h3>
                        <p class="text">${proteins?size} proteins in PSnpBind database from PDB</p>
					</div> <!-- row -->
                </div>
            </div> <!-- row -->
            <div class="row justify-content-center">
				<#list proteins as protein>
				
                <div class="col-lg-4 col-md-4 col-sm-12" style="margin-bottom: 15px;">
					<div class="card" style="height: 100%;">
					  <a href="protein/${protein.pdbId}"><img src="http://cdn.rcsb.org/images/structures/${protein.pdbId?string[1..2]}/${protein.pdbId}/${protein.pdbId}_assembly-1.jpeg" class="card-img-top img-responsive" alt="${protein.pdbId}"></a>
					  <div class="card-body">
						<p class="card-text text-center">${protein.proteinName}</p>
					  </div>
					</div>
                </div>
				<#if protein?counter % 3 == 0  >
					</div>
					<div class="row justify-content-center">
				</#if>
				</#list>
            </div> <!-- row -->
        </div> <!-- container -->
    </section>

<#include "/fragments/footer.ftl">
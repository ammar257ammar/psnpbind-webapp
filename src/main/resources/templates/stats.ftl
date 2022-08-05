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
            <div class="row justify-content-center">
                <div class="col-lg-6 col-md-10">
                    <div class="section-title text-center pb-10">
                        <h4 class="table-title">PSnpBind Statistics</h4>
					</div> <!-- row -->
                </div>
            </div> <!-- row -->
            <div class="row justify-content-center">
				
				<div class="col-md-12 col-sm-12">
					
					<table class="table table-striped">
					
					   <tr>
					           <th>UniProt ID</th>
					           <th>PDB ID</th>
					           <th># of protein structures (wild-type & variants)</th>
					           <th># of ligands</th>
					           <th># of dockings</th>
					   </tr>
					   <tr>
					           <td> <a href="https://www.uniprot.org/uniprot/P00749" title="P00749">P00749</a></td>
					           <td> <a href="https://www.rcsb.org/structure/1owh" title="1owh">1owh</a></td>
					           <td>38</td>
					           <td>1901</td>
					           <td>72225</td>
					   </tr>
                                           <tr>
                                                   <td> <a href="https://www.uniprot.org/uniprot/P11309" title="P11309">P11309</a></td>
                                                   <td> <a href="https://www.rcsb.org/structure/2c3i" title="2c3i">2c3i</a></td>
                                                   <td>18</td>
                                                   <td>1240</td>
                                                   <td>22316</td>
                                           </tr>					
                                           <tr>
                                                   <td> <a href="https://www.uniprot.org/uniprot/P18031" title="P18031">P18031</a></td>
                                                   <td> <a href="https://www.rcsb.org/structure/2hb1" title="2hb1">2hb1</a></td>
                                                   <td>18</td>
                                                   <td>419</td>
                                                   <td>7531</td>
                                           </tr>
                                           <tr>
                                                   <td> <a href="https://www.uniprot.org/uniprot/P03372" title="P03372">P03372</a></td>
                                                   <td> <a href="https://www.rcsb.org/structure/2pog" title="2pog">2pog</a></td>
                                                   <td>13</td>
                                                   <td>7017</td>
                                                   <td>91217</td>
                                           </tr>
                                           <tr>
                                                   <td> <a href="https://www.uniprot.org/uniprot/P00918" title="P00918">P00918</a></td>
                                                   <td> <a href="https://www.rcsb.org/structure/2weg" title="2weg">2weg</a></td>
                                                   <td>22</td>
                                                   <td>1013</td>
                                                   <td>22281</td>
                                           </tr>
                                           <tr>
                                                   <td> <a href="https://www.uniprot.org/uniprot/P00742" title="P00742">P00742</a></td>
                                                   <td> <a href="https://www.rcsb.org/structure/2y5h" title="2y5h">2y5h</a></td>
                                                   <td>33</td>
                                                   <td>667</td>
                                                   <td>22010</td>
                                           </tr>
                                           <tr>
                                                   <td> <a href="https://www.uniprot.org/uniprot/P07900" title="P07900">P07900</a></td>
                                                   <td> <a href="https://www.rcsb.org/structure/3b27" title="3b27">3b27</a></td>
                                                   <td>21</td>
                                                   <td>1954</td>
                                                   <td>41023</td>
                                           </tr>
                                           <tr>
                                                   <td> <a href="https://www.uniprot.org/uniprot/P10275" title="P10275">P10275</a></td>
                                                   <td> <a href="https://www.rcsb.org/structure/3b5r" title="3b5r">3b5r</a></td>
                                                   <td>83</td>
                                                   <td>466</td>
                                                   <td>38671</td>
                                           </tr>
                                           <tr>
                                                   <td> <a href="https://www.uniprot.org/uniprot/P39086" title="P39086">P39086</a></td>
                                                   <td> <a href="https://www.rcsb.org/structure/3fv1" title="3fv1">3fv1</a></td>
                                                   <td>43</td>
                                                   <td>345</td>
                                                   <td>14782</td>
                                           </tr>
                                           <tr>
                                                   <td> <a href="https://www.uniprot.org/uniprot/O14757" title="O14757">O14757</a></td>
                                                   <td> <a href="https://www.rcsb.org/structure/3jvr" title="3jvr">3jvr</a></td>
                                                   <td>11</td>
                                                   <td>631</td>
                                                   <td>6933</td>
                                           </tr>
                                           <tr>
                                                   <td> <a href="https://www.uniprot.org/uniprot/P24941" title="P24941">P24941</a></td>
                                                   <td> <a href="https://www.rcsb.org/structure/3pxf" title="3pxf">3pxf</a></td>
                                                   <td>10</td>
                                                   <td>505</td>
                                                   <td>5044</td>
                                           </tr>
                                           <tr>
                                                   <td> <a href="https://www.uniprot.org/uniprot/P37231" title="P37231">P37231</a></td>
                                                   <td> <a href="https://www.rcsb.org/structure/3u9q" title="3u9q">3u9q</a></td>
                                                   <td>20</td>
                                                   <td>606</td>
                                                   <td>12114</td>
                                           </tr>
                                           <tr>
                                                   <td> <a href="https://www.uniprot.org/uniprot/P56817" title="P56817">P56817</a></td>
                                                   <td> <a href="https://www.rcsb.org/structure/3udh" title="3udh">3udh</a></td>
                                                   <td>5</td>
                                                   <td>2127</td>
                                                   <td>10635</td>
                                           </tr>
                                           <tr>
                                                   <td> <a href="https://www.uniprot.org/uniprot/O14965" title="O14965">O14965</a></td>
                                                   <td> <a href="https://www.rcsb.org/structure/3up2" title="3up2">3up2</a></td>
                                                   <td>18</td>
                                                   <td>895</td>
                                                   <td>16109</td>
                                           </tr>
                                           <tr>
                                                   <td> <a href="https://www.uniprot.org/uniprot/P00734" title="P00734">P00734</a></td>
                                                   <td> <a href="https://www.rcsb.org/structure/3utu" title="3utu">3utu</a></td>
                                                   <td>27</td>
                                                   <td>1796</td>
                                                   <td>48492</td>
                                           </tr>
                                           <tr>
                                                   <td> <a href="https://www.uniprot.org/uniprot/P03951" title="P03951">P03951</a></td>
                                                   <td> <a href="https://www.rcsb.org/structure/4crc" title="4crc">4crc</a></td>
                                                   <td>50</td>
                                                   <td>690</td>
                                                   <td>34496</td>
                                           </tr>
                                           <tr>
                                                   <td> <a href="https://www.uniprot.org/uniprot/Q16539" title="Q16539">Q16539</a></td>
                                                   <td> <a href="https://www.rcsb.org/structure/4dli" title="4dli">4dli</a></td>
                                                   <td>9</td>
                                                   <td>1320</td>
                                                   <td>11878</td>
                                           </tr>
                                           <tr>
                                                   <td> <a href="https://www.uniprot.org/uniprot/P23458" title="P23458">P23458</a></td>
                                                   <td> <a href="https://www.rcsb.org/structure/4e5w" title="4e5w">4e5w</a></td>
                                                   <td>9</td>
                                                   <td>1090</td>
                                                   <td>9801</td>
                                           </tr>
                                           <tr>
                                                   <td> <a href="https://www.uniprot.org/uniprot/P39900" title="P39900">P39900</a></td>
                                                   <td> <a href="https://www.rcsb.org/structure/4gr0" title="4gr0">4gr0</a></td>
                                                   <td>38</td>
                                                   <td>1090</td>
                                                   <td>41419</td>
                                           </tr>
                                           <tr>
                                                   <td> <a href="https://www.uniprot.org/uniprot/Q9H2K2" title="Q9H2K2">Q9H2K2</a></td>
                                                   <td> <a href="https://www.rcsb.org/structure/4j21" title="4j21">4j21</a></td>
                                                   <td>17</td>
                                                   <td>3295</td>
                                                   <td>56001</td>
                                           </tr>
                                           <tr>
                                                   <td> <a href="https://www.uniprot.org/uniprot/O60674" title="O60674">O60674</a></td>
                                                   <td> <a href="https://www.rcsb.org/structure/4jia" title="4jia">4jia</a></td>
                                                   <td>7</td>
                                                   <td>848</td>
                                                   <td>5930</td>
                                           </tr>
                                           <tr>
                                                   <td> <a href="https://www.uniprot.org/uniprot/Q08881" title="Q08881">Q08881</a></td>
                                                   <td> <a href="https://www.rcsb.org/structure/4m0y" title="4m0y">4m0y</a></td>
                                                   <td>19</td>
                                                   <td>169</td>
                                                   <td>3197</td>
                                           </tr>
                                           <tr>
                                                   <td> <a href="https://www.uniprot.org/uniprot/P00519" title="P00519">P00519</a></td>
                                                   <td> <a href="https://www.rcsb.org/structure/4twp" title="4twp">4twp</a></td>
                                                   <td>26</td>
                                                   <td>795</td>
                                                   <td>20662</td>
                                           </tr>
                                           <tr>
                                                   <td> <a href="https://www.uniprot.org/uniprot/O60885" title="O60885">O60885</a></td>
                                                   <td> <a href="https://www.rcsb.org/structure/4wiv" title="4wiv">4wiv</a></td>
                                                   <td>3</td>
                                                   <td>917</td>
                                                   <td>2747</td>
                                           </tr>
                                           <tr>
                                                   <td> <a href="https://www.uniprot.org/uniprot/P04637" title="P04637">P04637</a></td>
                                                   <td> <a href="https://www.rcsb.org/structure/5a7b" title="5a7b">5a7b</a></td>
                                                   <td>160</td>
                                                   <td>113</td>
                                                   <td>17996</td>
                                           </tr>
                                           <tr>
                                                   <td> <a href="https://www.uniprot.org/uniprot/Q9Y233" title="Q9Y233">Q9Y233</a></td>
                                                   <td> <a href="https://www.rcsb.org/structure/5c28" title="5c28">5c28</a></td>
                                                   <td>13</td>
                                                   <td>352</td>
                                                   <td>4567</td>
                                           </tr>
                                           <tr>
                                                   <td colspan="2"><p class="font-weight-bold justify-content-center">Total</p></td>
                                                   <td>731</td>
                                                   <td>32261</td>
                                                   <td>640074</td>
                                           </tr>
					</table>
				</div>
            </div> <!-- row -->			
        </div> <!-- container -->
    </section>
	
<#include "/fragments/footer.ftl">
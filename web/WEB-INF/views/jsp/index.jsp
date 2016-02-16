<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Meteo Station in Santhià (Vc) via Palestro n.8">
    <meta name="author" content="marco berri marcoberri@gmail.com">
    <title>Meteo Station Farnese A1 - Santhià (VC)</title>
    <link href="${pageContext.request.contextPath}/resources/bootstrap-3.3.6-dist/css/bootstrap.min.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    
  </head>
  <body>  
     	
    <div class="navbar-wrapper">
      <div class="container">
        <div class="navbar navbar-inverse navbar-static-top" role="navigation">
          <div class="container">
            <div class="navbar-header">
              <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
              <a class="navbar-brand" href="#">Meteo Station Farnese A1</a>
            </div>
            <div class="navbar-collapse collapse">
              <ul class="nav navbar-nav">
                <li class="active"><a href="${pageContext.request.contextPath}/">Home</a></li>
                <li><a href="#24h">24 H</a></li>
                <li><a href="#7d">7 Day</a></li>
                <li><a href="#30d">30 Day</a></li>
                <li><a href="#365d">365 Day</a></li>
                <li><a href="#" onClick="$('#statusModal').modal('show')">Status</a></li>
                <li><a href="#" onClick="$('#aboutModal').modal('show')">About</a></li>
              </ul>
            </div>
          </div>
        </div>

      </div>
    </div>
    
   <div class="container marketing">



<section id="24h">

      <!-- START THE FEATURETTES -->
      <div class="row featurette">
      
      	<div class="span4"></div>
        	<div class="span4">
        		<h2 class="center-block">Last 24 Hours</h2>
        	</div>
        <div class="span4"></div>
      </div>
      
      <div class="row featurette">
        <div class="col-md-6">
			        
		<p>
			<dl class="dl-horizontal">
			  <dt>TS:</dt>
			  <dd>${last.ts}</dd>
			</dl>
			<dl class="dl-horizontal">
			  <dt>Temperature:</dt>
			  <dd>${last.t1}&deg;</dd>
			</dl>
			
			<!-- dl class="dl-horizontal">
			  <dt>Temperature Max/Min:</dt>
			  <dd> 15.1&deg; / 0.4&deg; (24H)</dd>
			</dl-->
			
			<dl class="dl-horizontal">
			  <dt>Humidity:</dt>
			  <dd>${last.h1}%</dd>
			</dl>
			
			
			<!-- dl class="dl-horizontal">
			  <dt>Humidity Max/Min:</dt>
			  <dd> 83% / 64% (24H)</dd>
			</dl-->
			
			<dl class="dl-horizontal">
			  <dt>Pressure:</dt>
			  <dd>${last.press} mBar</dd>
			</dl>
			
			<!-- dl class="dl-horizontal">
			  <dt>Pressure Max/Min:</dt>
			  <dd> 996.1 mBar / 990.1 mBar (24H)</dd>
			</dl-->
			
			<dl class="dl-horizontal">
			  <dt>Wind direction:</dt>
			  <dd>${last.wd}</dd>
			</dl>
			
			<dl class="dl-horizontal">
			  <dt>Wind speed:</dt>
			  <dd>${last.ws} m/s</dd>
			</dl>
			
			<dl class="dl-horizontal">
			  <dt>Windchill temperature:</dt>
			  <dd>${last.wc} &deg;</dd>
			</dl>
        </p>	        
		</div>
        
        
        <div class="col-md-6">
			<img style="margin-top:5px;" class="featurette-image img-responsive" src="${pageContext.request.contextPath}/draw/T/1/700/500" alt="Temperature"/>        
		</div>
      </div>



      <div class="row featurette">
        <div class="col-md-6">
			       <img style="margin-top:5px;" class="featurette-image img-responsive" src="${pageContext.request.contextPath}/draw/H/1/700/500" alt="humidity"/>
		</div>
        
        
        <div class="col-md-6">
			<img style="margin-top:5px;" class="featurette-image img-responsive" src="${pageContext.request.contextPath}/draw/PRESS/1/700/500" alt="Pressure"/>        
		</div>
      </div>


      <div class="row featurette">
        <div class="col-md-6">
			       <img style="margin-top:5px;" class="featurette-image img-responsive" src="${pageContext.request.contextPath}/draw/WC/1/700/500" alt="Wind Chill"/>
		</div>
        
        
        <div class="col-md-6">
			<img style="margin-top:5px;" class="featurette-image img-responsive" src="${pageContext.request.contextPath}/draw/WS/1/700/500" alt=""/>        
		</div>
      </div>
      
	<p class="pull-right"><a href="#" title="Top Page">Top</a></p>

</section>



 <hr class="featurette-divider">






<section id="7d">

      <!-- START THE FEATURETTES -->
      <div class="row featurette">
      
      	<div class="span4"></div>
        	<div class="span4">
        		<h2 class="center-block">Last 7 Day</h2>
        	</div>
        <div class="span4"></div>
        
      </div>
      
      <div class="row featurette">

        <div class="col-md-6">
			<img style="margin-top:5px;" class="featurette-image img-responsive" src="${pageContext.request.contextPath}/draw/T/7/700/500" alt="Temperature"/>        
		</div>
        
        
        <div class="col-md-6">
			<img style="margin-top:5px;" class="featurette-image img-responsive" src="${pageContext.request.contextPath}/draw/H/7/700/500" alt="Humidity"/>        
		</div>
		
      </div>



      <div class="row featurette">

        <div class="col-md-6">
			<img style="margin-top:5px;" class="featurette-image img-responsive" src="${pageContext.request.contextPath}/draw/PRESS/7/700/500" alt="Pressure last 7 day"/>        
		</div>
        
        
        <div class="col-md-6">
			<img style="margin-top:5px;" class="featurette-image img-responsive" src="${pageContext.request.contextPath}/draw/WC/7/700/500" alt="Wind Chill last 7 day"/>        
		</div>
      </div>


      <div class="row featurette">
        <div class="col-md-6">
			<img style="margin-top:5px;" class="featurette-image img-responsive" src="${pageContext.request.contextPath}/draw/WS/7/700/500" alt="Wind Speed last 7 day"/>        
		</div>
        
        
        <div class="col-md-6">
        
		</div>
      </div>
      
	<p class="pull-right"><a href="#" title="Top Page">Top</a></p>

</section>



 <hr class="featurette-divider">








<section id="30d">

      <!-- START THE FEATURETTES -->
      <div class="row featurette">
      
      	<div class="span4"></div>
        	<div class="span4">
        		<h2 class="center-block">Last 30 Day</h2>
        	</div>
        <div class="span4"></div>
        
      </div>
      
      <div class="row featurette">

        <div class="col-md-6">
			<img style="margin-top:5px;" class="featurette-image img-responsive" src="${pageContext.request.contextPath}/draw/T/30/700/500" alt="Temperature"/>        
		</div>
        
        
        <div class="col-md-6">
			<img style="margin-top:5px;" class="featurette-image img-responsive" src="${pageContext.request.contextPath}/draw/H/30/700/500" alt="Humidity"/>        
		</div>
		
      </div>



      <div class="row featurette">

        <div class="col-md-6">
			<img style="margin-top:5px;" class="featurette-image img-responsive" src="${pageContext.request.contextPath}/draw/PRESS/30/700/500" alt="Pressure last 7 day"/>        
		</div>
        
        
        <div class="col-md-6">
			<img style="margin-top:5px;" class="featurette-image img-responsive" src="${pageContext.request.contextPath}/draw/WC/30/700/500" alt="Wind Chill last 7 day"/>        
		</div>
      </div>


      <div class="row featurette">
        <div class="col-md-6">
			<img style="margin-top:5px;" class="featurette-image img-responsive" src="${pageContext.request.contextPath}/draw/WS/30/700/500" alt="Wind Speed last 7 day"/>        
		</div>
        
        
        <div class="col-md-6">
        
		</div>
      </div>
      
	<p class="pull-right"><a href="#" title="Top Page">Top</a></p>

</section>



 <hr class="featurette-divider">
 
 
 
 
 
 



<section id="365d">

      <!-- START THE FEATURETTES -->
      <div class="row featurette">
      
      	<div class="span4"></div>
        	<div class="span4">
        		<h2 class="center-block">Last 365 Day</h2>
        	</div>
        <div class="span4"></div>
        
      </div>
      
      <div class="row featurette">
        <div class="col-md-12">
			<img style="margin-top:5px;" class="featurette-image img-responsive" src="${pageContext.request.contextPath}/draw/T/365/1200/500" alt="Temperature last 365 day"/>        
		</div>
      </div>

      <div class="row featurette">
        <div class="col-md-12">
			<img style="margin-top:5px;" class="featurette-image img-responsive" src="${pageContext.request.contextPath}/draw/H/365/1200/500" alt="Humidity last 365 day"/>        
		</div>
      </div>


      <div class="row featurette">
        <div class="col-md-12">
			<img style="margin-top:5px;" class="featurette-image img-responsive" src="${pageContext.request.contextPath}/draw/PRESS/365/1200/500" alt="Pressure last 365 day"/>        
		</div>
      </div>


      <div class="row featurette">
        <div class="col-md-12">
			<img style="margin-top:5px;" class="featurette-image img-responsive" src="${pageContext.request.contextPath}/draw/WC/365/1200/500" alt="Wind Chill last 365 day"/>        
		</div>
      </div>


      <div class="row featurette">
        <div class="col-md-12">
			<img style="margin-top:5px;" class="featurette-image img-responsive" src="${pageContext.request.contextPath}/draw/WS/365/1200/500" alt="Wind Speed last 365 day"/>        
		</div>
     </div>
      
	<p class="pull-right"><a href="#" title="Top Page">Top</a></p>

</section>



 <hr class="featurette-divider">
 
 
 

    <footer>
      <div class="container">
        <p class="text-muted"><a href="http://tecnicume.blogspot.it">&copy; Marco Berri - 2016</a></p>
      </div>
    </footer>
    
    
</div>





<!-- Modal -->

<div class="modal fade" id="aboutModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">About</h4>
      </div>
      <div class="modal-body">
        <strong>Hardware</strong><br/>
        Meteo Station : <a href="http://www.amazon.it/La-Crosse-Technology-WS1640-meteorologica/dp/B00JMANZLA">La Crosse Technology WS1640</a><br/>
        Meteo Station connected to <a href="https://www.raspberrypi.org/">Raspberry PI</a><br/>
        <br/>
        <strong>Software</strong><br/>
        Server: Ubuntu 14.10 on Linode.com<br/>
        Source Service to send data from Raspeberry PI to Site : <a href="https://github.com/marcoberri/mbmeteolacrossecaputre">github</a> in Java<br/>
        Source this site: <a href="https://github.com/marcoberri/mbmeteolacrossejava">github</a> in <a href="https://spring.io/">Spring Framework</a><br/>
        Source Batch to generate graph in crontab <a href="https://github.com/marcoberri/mbmeteolacrossegeneratechart">github</a> in Java<br/>
        Data stored in <a href="https://www.mongodb.org/">MongoDB</a> <br/>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>





<div class="modal fade" id="statusModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">System Status</h4>
      </div>
      <div class="modal-body">
        <strong>Hardware Status</strong><br/>
	
	<strong>Last check </strong> : ${lastsys.ts} <br/>
	<strong>Battery Rain</strong> : ${lastsys.batR}   <br/>
	<strong>Battery Wind</strong> : ${lastsys.batW}   <br/>
	<strong>Battery 1</strong> :  ${lastsys.bat1} <br/>
	<strong>Battery 2</strong> :  ${lastsys.bat1} <br/>
	<strong>Battery 3</strong> :  ${lastsys.bat3} <br/>
	<strong>Battery 4</strong> : ${lastsys.bat4}   <br/>
	<strong>Battery 5</strong> :  ${lastsys.bat5} <br/>

<br/>
<br/>
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>






    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="${pageContext.request.contextPath}/resources/jquery/jquery-1.12.0.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="${pageContext.request.contextPath}/resources/bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>
    
    
    
    <script>
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

  ga('create', 'UA-549048-18', 'auto');
  ga('send', 'pageview');

</script>


  </body>
</html>
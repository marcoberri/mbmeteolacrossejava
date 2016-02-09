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

    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>

    

 <nav class="navbar navbar-inverse navbar-fixed-top">

      <div class="container">

        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar" style="float:left;">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="http://meteo.marcoberri.it">Meteo Farnese A1 - Santhi&agrave; (VC)</a>
        </div>

 <div id="navbar" class="navbar-collapse collapse navbar-left">

          <ul class="nav navbar-nav">
	    <li><a href="#24">24 H</a></li>	
	    <li><a href="#7day">7 Day</a></li>	
	    <li><a href="#30day">30 Day</a></li>	
	    <!--li><a href="/365day">365 Day</a></li-->	
            <li><a href="#" onClick="$('#statusModal').modal('show')">Status</a></li>
            <li><a href="#" onClick="$('#aboutModal').modal('show')">About</a></li>
            <!--li><a href="#contact">Contact</a></li-->
          </ul>
        </div><!--/.nav-collapse -->


      </div>

    </nav>




      <hr>

    <footer class="footer">
      <div class="container">
        <p class="text-muted"><a href="http://tecnicume.blogspot.it">&copy; Marco Berri - 2016</a></p>
      </div>
    </footer>
    
    






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
        Source this site: <a href="https://github.com/marcoberri/mbmeteolacrosse">github</a> in <a href="https://nodejs.org/">NodeJS</a><br/>
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
	
	<strong>Last check </strong> : Mon Feb 08 2016 23:43:55 GMT+0100 (CET) <br/>
	<strong>Battery Rain</strong> : <span style="color:red">0</span>   <br/>
	<strong>Battery Wind</strong> : <span style="color:red">0</span>   <br/>
	<strong>Battery 1</strong> :  <span style="color:green">1</span> <br/>
	<strong>Battery 2</strong> :  <span style="color:green">1</span> <br/>
	<strong>Battery 3</strong> :  <span style="color:green">1</span> <br/>
	<strong>Battery 4</strong> : <span style="color:red">0</span>   <br/>
	<strong>Battery 5</strong> :  <span style="color:green">1</span> <br/>

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
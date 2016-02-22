<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description"
	content="Meteo Station in Santhià (Vc) via Palestro n.8">
<meta name="author" content="marco berri marcoberri@gmail.com">
<title>Meteo Station Farnese A1 - Santhià (VC)</title>
<link
	href="${pageContext.request.contextPath}/resources/bootstrap-3.3.6-dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/style.css"
	rel="stylesheet">
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>

	<div class="navbar-wrapper">
		<div class="container">
			<div class="navbar navbar-inverse navbar-static-top"
				role="navigation">
				<div class="container">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target=".navbar-collapse">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="${pageContext.request.contextPath}/">Archive</a>
					</div>
					<div class="navbar-collapse collapse">
						<ul class="nav navbar-nav">
							<li><a href="${pageContext.request.contextPath}/">Home</a></li>
							<li><a href="#T">Temperature</a></li>
							<li><a href="#H">Humidity</a></li>
							<li><a href="#PRESS">Pressure</a></li>
							<li><a href="#WC">Wind Chill</a></li>
							<li><a href="#WS">Wind Speed</a></li>
						</ul>
					</div>
				</div>
			</div>

		</div>
	</div>

	<div class="container marketing">









		<section id="T">

			<!-- START THE FEATURETTES -->
			<div class="row featurette">

				<div class="span4"></div>
				<div class="span4">
					<h2 class="center-block">Temperature</h2>
				</div>
				<div class="span4"></div>

			</div>


			<c:forEach items="${dates}" var="date">

				<div class="row featurette">
					<div class="col-md-12">
						<img style="margin-top: 5px;"
							class="featurette-image img-responsive"
							src="${pageContext.request.contextPath}/draw/archive/T/<c:out value="${date}" />/1200/300"
							alt="Temperature" />
					</div>
				</div>
			</c:forEach>



			<p class="pull-right">
				<a href="#" title="Top Page">Top</a>
			</p>

		</section>


		<hr class="featurette-divider">



		<section id="H">

			<!-- START THE FEATURETTES -->
			<div class="row featurette">

				<div class="span4"></div>
				<div class="span4">
					<h2 class="center-block">Humidity</h2>
				</div>
				<div class="span4"></div>

			</div>


			<c:forEach items="${dates}" var="date">

				<div class="row featurette">
					<div class="col-md-12">
						<img style="margin-top: 5px;"
							class="featurette-image img-responsive"
							src="${pageContext.request.contextPath}/draw/archive/H/<c:out value="${date}" />/1200/300"
							alt="Humidity" />
					</div>
				</div>
			</c:forEach>



			<p class="pull-right">
				<a href="#" title="Top Page">Top</a>
			</p>

		</section>


		<hr class="featurette-divider">

		<section id="PRESS">

			<!-- START THE FEATURETTES -->
			<div class="row featurette">

				<div class="span4"></div>
				<div class="span4">
					<h2 class="center-block">Pressure</h2>
				</div>
				<div class="span4"></div>

			</div>


			<c:forEach items="${dates}" var="date">

				<div class="row featurette">
					<div class="col-md-12">
						<img style="margin-top: 5px;"
							class="featurette-image img-responsive"
							src="${pageContext.request.contextPath}/draw/archive/PRESS/<c:out value="${date}" />/1200/300"
							alt="Humidity" />
					</div>
				</div>
			</c:forEach>



			<p class="pull-right">
				<a href="#" title="Top Page">Top</a>
			</p>

		</section>

		<hr class="featurette-divider">


		<section id="WC">

			<!-- START THE FEATURETTES -->
			<div class="row featurette">

				<div class="span4"></div>
				<div class="span4">
					<h2 class="center-block">Wind Chill</h2>
				</div>
				<div class="span4"></div>

			</div>


			<c:forEach items="${dates}" var="date">

				<div class="row featurette">
					<div class="col-md-12">
						<img style="margin-top: 5px;"
							class="featurette-image img-responsive"
							src="${pageContext.request.contextPath}/draw/archive/WC/<c:out value="${date}" />/1200/300"
							alt="Wind Chill" />
					</div>
				</div>
			</c:forEach>



			<p class="pull-right">
				<a href="#" title="Top Page">Top</a>
			</p>

		</section>

		<hr class="featurette-divider">


		<section id="WS">

			<!-- START THE FEATURETTES -->
			<div class="row featurette">

				<div class="span4"></div>
				<div class="span4">
					<h2 class="center-block">Wind Speed</h2>
				</div>
				<div class="span4"></div>

			</div>


			<c:forEach items="${dates}" var="date">

				<div class="row featurette">
					<div class="col-md-12">
						<img style="margin-top: 5px;"
							class="featurette-image img-responsive"
							src="${pageContext.request.contextPath}/draw/archive/WS/<c:out value="${date}" />/1200/300"
							alt="Wind Speed" />
					</div>
				</div>
			</c:forEach>



			<p class="pull-right">
				<a href="#" title="Top Page">Top</a>
			</p>

		</section>

		<hr class="featurette-divider">
		
		
		<footer>
			<div class="container">
				<p class="text-muted">
					<a href="http://tecnicume.blogspot.it">&copy; Marco Berri -
						2016</a>
				</p>
			</div>
		</footer>


	</div>




	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="${pageContext.request.contextPath}/resources/jquery/jquery-1.12.0.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script
		src="${pageContext.request.contextPath}/resources/bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>



	<script>
		(function(i, s, o, g, r, a, m) {
			i['GoogleAnalyticsObject'] = r;
			i[r] = i[r] || function() {
				(i[r].q = i[r].q || []).push(arguments)
			}, i[r].l = 1 * new Date();
			a = s.createElement(o), m = s.getElementsByTagName(o)[0];
			a.async = 1;
			a.src = g;
			m.parentNode.insertBefore(a, m)
		})(window, document, 'script',
				'//www.google-analytics.com/analytics.js', 'ga');

		ga('create', 'UA-549048-18', 'auto');
		ga('send', 'pageview');
	</script>


</body>
</html>
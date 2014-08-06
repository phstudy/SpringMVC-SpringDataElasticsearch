<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Home</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<!-- Optional theme -->
<link rel="stylesheet"
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
</head>
<body>
	<div class="container">
		<div class="row">
			<h1>Spring MVC + Spring Data Elasticsearch Example</h1>
			<ol>
				<li><a href="./pageable">Use <b>Pageable</b> to fetch HTTP GET parameter</a></li>
				<li><a href="./httpservletrequest">Use <b>HttpServletRequest</b> to fetch HTTP GET parameter</a></li>
				<li><a href="./requestparam">Use <b>@RequestParam</b> to fetch HTTP GET parameter</a></li>
				<li><a href="./search">Reload whole page (Traditional)</a></li>
			</ol>
		</div>
	</div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<!-- Latest compiled and minified JavaScript -->
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>

</html>

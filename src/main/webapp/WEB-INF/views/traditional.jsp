<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Traditional</title>
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
			<form id="myForm" action="./search" method="GET" class="navbar-form navbar-left" role="search">
				<div class="form-group">
					<input id='search' name="query" type="text" class="form-control" placeholder="Search" value="${param.query}" >
				</div>
				<button type="submit" class="btn btn-default">Message Query</button>
			</form>
		</div>

		<div class="row">
			<table id="table-data" class="table table-hover">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Message</th>
						<th>Price</th>
					</tr>
				</thead>
				<tbody >
					<c:forEach items="${books}" var="book">
						<tr>
		    				<td>${book.id}</td>
		    				<td>${book.name}</td>
		    				<td>${book.message}</td>
		    				<td>${book.price}</td>
	    				</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

		<div class="text-center">
			<div id="page-selection" class="pagination-sm"></div>
		</div>
	</div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<!-- Latest compiled and minified JavaScript -->
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	<script src="./resources/js/jquery.bootpag.js"></script>
	<script>
		$(function() {			
			$('#page-selection').bootpag({
				total : 10,
				visiblePages : 10
			}).on("page", function(event, num) {
				var query = $('#search').val();
				window.location = './search?query=' + query + '&page=' + num;
			});
			
			$('#page-selection').bootpag({total: ${total}, page: ${page}, maxVisible: 10});
		});
	</script>
</body>

</html>

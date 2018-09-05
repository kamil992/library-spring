<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>

<link rel="stylesheet" 
 	   href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
 	   integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous" />

</head>

<body>

<h3>List of Books</h3>

<hr>
<div>
	<table class="table table-dark">
	
	<tr>
		<th>TITLE</th>
	    <th>AUTHOR</th>
		<th>YEAR</th>
		<th>PUBLISHER</th>
		<th>DESCRIPTION</th>
	</tr>
	
	<c:forEach var="books" items="${booksList}">
	
	<tr>
		<td> ${books.title} </td>
		<td> <a ref="/">${books.author}</a> </td>
		<td> ${books.year} </td>
		<td> ${books.publisher}</td>
		<td> ${books.description}</td>
	</tr>
	
	</c:forEach>
	
	</table>
</div>

<style>
	tr{
	margin: 10px;
	}
	th{
	margin: 10px;
	}
	td{
	margin: 10px;
	}
</style>
</body>
</html>
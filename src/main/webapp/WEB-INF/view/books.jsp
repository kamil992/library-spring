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

<div class="container-fluid">

	<c:forEach var="books" items="${booksList}">
	
	<div class="card w-100">
  		<div class="card-body">
    		<div class="card-title">
    			<h5>Title: ${books.title}</h5>
    			<h7>Author: ${books.authorName}</h3>
    		</div>
    		<div class="card-text">
    			<p>Description: ${books.description}</p>
    		</div>
    		<a href="#" class="btn btn-primary">View more</a>
  		</div>
	</div>
	
	</c:forEach>
	
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
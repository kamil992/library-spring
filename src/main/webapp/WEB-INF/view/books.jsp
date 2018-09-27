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

<div class="container">

	<c:forEach var="books" items="${booksList}">
	
	<div class="card w-100">
  		<div class="card-body">
    		<div class="card-title">
    			<div class = "row">
    				<div class="col-sm-2">
    					<img id="picture" src="${books.picture}"/>
    				</div>
    				<div class="col-sm-10">
    					<h5>Title: <a href="${pageContext.request.contextPath}/book/${books.id}"> ${books.title}</a></h5>
    					<h7>Author: <a href="${pageContext.request.contextPath}/author/${books.author.id}">${books.author.fullName}</a></h7>
    					<div class="card-text">
    						<p>Description: ${books.description}</p>
    					</div>
    				</div>
    			
    			</div>
    
    		</div>
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
	
	#picture{
		height: 140px;
		width: 100px;
	}
</style>
</body>
</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<title>library</title>

<link rel="stylesheet" 
 	   href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
 	   integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous" />
</head>

<body>
<h3><a href="${pageContext.request.contextPath}/books">List of Books</a></h3>

	<div class="container">
		<div class="row">
			<div class="col-sm-3">
  				<img id="photo"  src="${author.picture}" />
  			</div>
  			<div class="col-sm-9">
  				 <h5 class="author">${author.fullName}</h5>
  				 <h7>${author.lifeDate}</h7>
  				 <p>${author.description}</p>
  			 </div>
  		</div>
  		<hr>
  	
  	<h7>Books:</h7><br>
 	<c:forEach var="books" items="${listOfBooks}">
 	
 		<a href="${pageContext.request.contextPath}/book/${books.id}"> ${books.title}</a> (${books.year})<br/>
 	</c:forEach>
  
	</div>
	
	
	
	
	
	
	<style>
	
	body{
		margin: 10px;}
	
	#photo{
		height: 280px;
		width: 230px;}
		
	td.author{
		
	
	</style>
</body>
</html>
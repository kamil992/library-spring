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
	<div class="container-fluid">
	<table>
		<tr>
  			<td><img id="photo"  src="${author.picture}" /></td>
  			<td class="author"> ${author.fullName} (${author.lifeDate})
  				 ${author.description}</td>
  		</tr>
  	</table>
  	
  	<h7>Books:</h7>
 	<c:forEach var="books" items="${listOfBooks}">
 	
 		<p> ${books.title} (${books.year})</p>
 	</c:forEach>
  
	</div>
	
	
	
	
	
	
	<style>
	
	body{
		margin: 10px;}
	
	#photo{
		height: 280px;
		width: 250px;'}
		
	td.author{
		text-align: left;
		min-width: 450px;
		min-height: 650px;
		padding: 5px;}
	
	</style>
</body>
</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<title>library</title>

<link rel="stylesheet" 
 	   href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
 	   integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous" />
<link href="https://fonts.googleapis.com/css?family=Lobster&amp;subset=latin-ext" rel="stylesheet">
</head>

<body>
<h3 id="title"><a href="${pageContext.request.contextPath}/">Library</a></h3>

<c:choose>
<c:when test="${isLogin == false}">
<div class="signs">
<table>
<tr>
<td>
<a id="register" href="${pageContext.request.contextPath}/register">sign up </a>  
</td>
<td>
<a href="${pageContext.request.contextPath}/login">sign in </a>
</td>
</tr>
</table>
</div>
</c:when>
<c:when test="${isLogin == true}">
	<table>
		<tr>
			<td>
				<a id="register" href="${pageContext.request.contextPath}/logout">logout</a>  
			</td>
			<td>
				${userLogin}
			</td>
		</tr>
	</table>
</c:when>
</c:choose>
<hr>

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
	
	#title{
		font-family: 'Lobster', sans-serif;
		font-size: 54px;
		font-weight: 400;
		margin: 10px;
	}
	
	body{
		margin: 10px;}
	
	#photo{
		height: 280px;
		width: 230px;}
		
	a:link{
		text-decoration: none;
	}
	#register{
		margin-left: 20px;
		margin-right: 30px;
	}
	</style>
</body>
</html>
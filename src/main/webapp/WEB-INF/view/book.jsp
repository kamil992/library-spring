<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html
>
<head>
<link rel="stylesheet" 
 	   href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
 	   integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous" />

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
<h3><a href="${pageContext.request.contextPath}/books">List of Books</a></h3>

	<div class="container">
		<div class="row">
			<div class="col-sm-3">
				<img id="photo"  src="${book.picture}" />
			</div>
			<div class="col-sm-9">
				<h5>${book.title} (${book.year})</h5>
				<p><a href="${pageContext.request.contextPath}/author/${book.author.id}">${book.author.fullName}</a></p>
				<p>${book.description}</p>
			</div>
		</div>
	</div>


<style>
	
	body{
		margin: 10px;}
	
	#photo{
		height: 280px;
		width: 230px;}
		
		
	
	</style>
</body>
</html>
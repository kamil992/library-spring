<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
<link rel="stylesheet" 
 	   href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
 	   integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous" />
<link href="https://fonts.googleapis.com/css?family=Lobster&amp;subset=latin-ext" rel="stylesheet">
</head>
<body>

<h3><a id="title" href="${pageContext.request.contextPath}/">Library</a></h3>
<hr>
	<div id="container">
	<center>
	<h2>Registration</h2>

	<form:form modelAttribute="userToRegister" action="register" method="POST">
	
		<form:hidden path="id" />

		<table>
			<tbody>
				<tr>
					<td><label>Login:</label></td>
					<td><form:input path="login"/></td>
				</tr>
				<tr>
					<td><label>Email:</label></td>
					<td><form:input path="email"/></td>
				</tr>
				<tr>
					<td><label>Password:</label></td>
					<td><form:input path="password"/></td>
				</tr>
			</tbody>
		</table><br/>
				
				<input type="submit" value="SAVE" class="save"/>
				
	</form:form>
	</center>	
</div>

<style>
	#title{
		font-family: 'Lobster', sans-serif;
		font-size: 54px;
		font-weight: 400;
		margin: 10px;
	}
	a:link{
		text-decoration: none;
	}

</style>
</body>
</html>
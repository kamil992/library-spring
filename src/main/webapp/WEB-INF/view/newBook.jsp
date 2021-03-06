<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" 
 	   href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
 	   integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous" />
<link href="https://fonts.googleapis.com/css?family=Lobster&amp;subset=latin-ext" rel="stylesheet">
</head>

<body>

<h3><a id="title" href="${pageContext.request.contextPath}/">Library</a></h3>
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

<div id="container">
	<center>
	<h2>Add New Book</h2>
	
	<!--<c:if test="${checkIfExist != null}">
   			<p style="color: red;"><c:out value="${checkIfExist}"/></p>
   	</c:if>!-->

	<form:form modelAttribute="newBook" action="addBook" method="POST">
		
		<form:hidden path="id" />
		<table>
			<tbody>
				<tr>
					<td><label>Title:</label></td>
					<td><form:input id="l" path="title"/></td>
				</tr>
				<tr>
					<td><label>Author:</label></td>
					<td>
						<select name="authorName">
							<c:forEach var="author" items="${authorsList}">
							 	<option>${author.fullName}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td><label>Year of publication:</label></td>
					<td><form:input type="number" path="year"/></td>
				</tr>
				<tr>
					<td><label>Publishing house:</label></td>
					<td><form:input path="publisher"/></td>
				</tr>
				<tr>
					<td><label>Category:</label></td>
					<td>
						<select name="categoryName">
							<c:forEach var="category" items="${categories}">
							 	<option>${category.name}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td><label>Picture:</label></td>
					<td><form:input path="picture"/></td>
				</tr>
				<tr>
					<td><label>Description:</label></td>
					<td><form:input path="description"/></td>
				</tr>
			</tbody>
		</table><br/>
				
				<input type="submit" value="ADD BOOK" class="save"/>
				
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
#register{
		margin-left: 20px;
		margin-right: 30px;
	}

</style>

</body>
</html>
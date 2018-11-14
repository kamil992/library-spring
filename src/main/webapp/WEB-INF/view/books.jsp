<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>

<link rel="stylesheet" 
 	   href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
 	   integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous" />
<link href="https://fonts.googleapis.com/css?family=Lobster&amp;subset=latin-ext" rel="stylesheet">
</head>

<body>

<h3><a id="title" href="${pageContext.request.contextPath}/">Library</a></h3>
<a href="${pageContext.request.contextPath}/register">registration</a>
<hr>

<div class="container">
	<div class="content">
	
	<div id="searchByContainer">
	<div id="search">	   
	<form:form action="search" method="POST">
            <input type="text" name="searchingTitle" />                
            <input type="submit" value="Search" class="add-button" />
    </form:form><br>
    </div>
    
    <div id="category">
    	 <label id="category-label" ></label>   
    	 <a href="${pageContext.request.contextPath}/">All  </a> /      	
         <c:forEach var="categories" items="${categories}">
            <a href="${pageContext.request.contextPath}/${categories.name}">${categories.name}</a> /
          </c:forEach>    
    </div>
    </div>

         
         
	<c:forEach var="books" items="${booksList}">
	
	<div id="card" class="card w-100">
  		<div class="card-body">
    		<div class="card-title">
    			<div class = "row">
    				<div class="col-sm-2">
    					<img id="picture" src="${books.picture}"/>
    				</div>
    				<div class="col-sm-10">
    					<h7><a href="${pageContext.request.contextPath}/book/${books.id}"> ${books.title}</a></h7>
    					
    					<p>
    						<c:forEach var="categs" items="${books.categories}">
    						<a id="categ" href="${pageContext.request.contextPath}/${categs.name}">${categs.name}</a>
    						</c:forEach>
    					</p>
    					
    					<p id="author">Author: <a href="${pageContext.request.contextPath}/author/${books.author.id}">${books.author.fullName}</a></p>
    					<div class="card-text">
    						<p id = "description">${books.description}</p>
    					</div>
    				</div>
    			
    			</div>
    
    		</div>
  		</div>
	</div>
	
	</c:forEach>

</div>	
</div>

<style>
	#title{
		font-family: 'Lobster', sans-serif;
		font-size: 54px;
		font-weight: 400;
		margin: 10px;
	}
	#card{
		height: 180px;
	}
	
	#picture{
		height: 140px;
		width: 100px;
	}
	#description{
		font-size: 12;
	}
	#author{
		font-size: 13;
	}
	#category{
		float: left;
		margin-left: 40px;
	}
	#search{
		float: left;
	}
	a:link{
		text-decoration: none;
	}
	#categ{
		font-size: 12px;
	}
	
</style>
</body>
</html>
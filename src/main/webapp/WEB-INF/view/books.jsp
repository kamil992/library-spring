<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>

<link rel="stylesheet" 
 	   href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
 	   integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous" />

</head>

<body>

<h3><a id="title" href="${pageContext.request.contextPath}/books">List of Books</a></h3>

<hr>

<div class="container">
	<div class="content">
	
	<div id="searchByContainer">
	<div id="search">	   
	<form:form action="search" method="POST">
            Search book: <input type="text" name="searchingTitle" />
                
            <input type="submit" value="Search" class="add-button" />
    </form:form><br>
    </div>
    <div  id="category">
    	 <label id="category-label" for="category">
          Category:
          </label>
           <select id="category-drop" class="dropdown">
          <option disabled value>Select an option:</option>
          <option value="">Adventure</option>
          <option value="">Employee</option>
          <option value="">Graduate</option>
          <option value="">Uneployed</option>
          <option value="">Learner</option>
          <option value="">Amateur</option></select>
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
	
</style>
</body>
</html>
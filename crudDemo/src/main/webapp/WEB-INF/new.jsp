<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>      
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" div>="anonymous"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
      <div class=container>
           <h1>Create a Book</h1>
     <div class="container mt-4">
             
	        <form:form action="/books" method="post" modelAttribute="book">
	    <div>
	        <form:label path="title">Title</form:label>
	        <form:errors path="title"/>
	        <form:input path="title"/>
	    </div>
	    <div>
	        <form:label path="description">Description</form:label>
	        <form:errors path="description"/>
	        <form:textarea path="description"/>
	    </div>
	    <div>
	        <form:label path="language">Language</form:label>
	        <form:errors path="language"/>
	        <form:input path="language"/>
	    </div>
	    <div>
	        <form:label path="numberOfPages">Pages</form:label>
	        <form:errors path="numberOfPages"/>     
	        <form:input type="number" path="numberOfPages"/>
	    </div>    
	    <input type="submit" value="Submit"/>
	  </form:form>
	    <a href="/books">New Book</a>
     </div>
      </div>
</body>
</html>
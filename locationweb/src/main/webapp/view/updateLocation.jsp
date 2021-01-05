<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Location</title>
</head>
<body>
<h1>Update Location</h1>
<hr/>
<form action="updateLocation" method="post">
<pre>
Id : <input type="text" name = "id" placeholder="${location.id}"/> 

Code : <input type="text" name = "code" placeholder="${location.code}"/> 

Name : <input type="text" name = "name" placeholder="${location.name}"/>

Type : Urban <input type="radio" value= "urban" name="type"/> Rural <input type="radio" value= "rural" name="type"/>

<input type="submit" name="save"/>
</pre>
</form>


<hr/>
</body>
</html>
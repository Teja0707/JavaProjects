<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Locations</title>
</head>
<body>
<h3>Locations</h3>
<table border="1">
  <tr>
    <th>ID</th>
    <th>CODE</th>
    <th>NAME</th>
    <th>TYPE</th>
  </tr>
  <c:forEach var="location" items="${locations}">
  <tr>
    <td>${location.id}</td>
    <td>${location.code}</td>
    <td>${location.name}</td>
    <td>${location.type}</td>
    <td><a href="deleteLocation?id=${location.id}" ><button>Delete</button></a></td>
    <td><a href="showUpdate?id=${location.id}" ><button>Edit</button></a></td>
  </tr>
  </c:forEach>
</table>
<p>
<a href="showCreate" ><button>Add Location</button></a>
</p>
<hr/>
${msg}
</body>
</html>
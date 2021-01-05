<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Vendors</title>
</head>
<body>
<h3>Vendor List</h3>
<table border="1">
<tr>
<th>ID</th>
<th>CODE</th>
<th>NAME</th>
<th>TYPE</th>
<th>EMAIL</th>
<th>PHONE</th>
<th>ADDRESS</th>
</tr>
<c:forEach var="vendor" items="${vendors}">
<tr>
<td>${vendor.id}</td>
<td>${vendor.code}</td>
<td>${vendor.name}</td>
<td>${vendor.type}</td>
<td>${vendor.email}</td>
<td>${vendor.phone}</td>
<td>${vendor.address}</td>
<td><a href="deleteVendor?id=${vendor.id}"><button>delete</button></a></td>
<td><a href="showUpdate?id=${vendor.id}"><button>edit</button></a></td>
</tr>
</c:forEach>
</table>
<br/>
<a href="showCreate"><button>Add Vendors</button></a>
<hr/>
${msg}
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Vendor</title>
</head>
<body>

<h3>Update Vendor</h3>
<hr/>

<form action="updateVendor" method="post">
<pre>

ID : <input type ="text" name="id" placeholder="${vendor.id}"/>

CODE : <input type ="text" name="code" placeholder="${vendor.code}"/>

NAME : <input type ="text" name="name" placeholder="${vendor.name}"/>

TYPE : Regular<input type ="radio" name="type" value="regular"/> Contract<input type ="radio" name="type" value="contract"/>

EMAIL : <input type ="text" name="email" placeholder="${vendor.email}"/>

PHONE : <input type ="text" name="phone" placeholder="${vendor.phone}"/>

ADDRESS : <textarea name="address">${vendor.address}</textarea>

<input type="submit" name="save">

</pre>
</form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Vendor</title>
</head>
<body>
<h1>Create Vendor</h1>
<hr/>

<form action="saveVendor" method="post">
<pre>

ID : <input type ="text" name="id"/>

CODE : <input type ="text" name="code"/>

NAME : <input type ="text" name="name"/>

TYPE : Regular<input type ="radio" name="type" value="regular"/> Contract<input type ="radio" name="type" value="contract"/>

EMAIL : <input type ="text" name="email"/>

PHONE : <input type ="text" name="phone"/>

ADDRESS : <textarea name="address">Enter address</textarea>

<input type="submit" name="save">
</pre>
</form>
<hr/>
<br/>
${msg}

<br/>
<br/>
<a href="viewVendors"><button>View Vendors</button></a>
<br/>
</body>
</html>
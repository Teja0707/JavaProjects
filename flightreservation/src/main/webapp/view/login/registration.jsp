<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flight Reservation</title>
</head>
<body>
<h1>User Registration</h1>
<pre>
${msg}
</pre>
<hr/>

<form action="registerUser" method="post">
<pre>

FIRST NAME : <input type ="text" name="firstName"/>

LAST NAME : <input type ="text" name="lastName"/>

EMAIL : <input type ="text" name="email"/>

PASSWORD : <input type ="password" name="password"/>

<input type="submit" name="save">

</pre>
</form>
<hr/>
<a href="showlogin"><button>Login</button></a>
</body>
</html>
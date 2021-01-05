<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<h3>Login</h3>
<pre>
${msg}
</pre>
<hr/>
<form action="loginUser" method="post">
<pre>
EMAIL : <input type ="text" name="email"/>

PASSWORD : <input type ="password" name="password"/>

<input type="submit" name="login">
</pre>
</form>
</body>
</html>
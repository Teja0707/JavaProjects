<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Flights</title>
</head>
<body>
<h1>Search flights</h1>
${msg}
<br/>
<br/>

<form action="findFlights" method="get">
To : <input type="text" name = "to" />
From : <input type="text" name = "from" />
Departure Date : <input type="text" name = "dateOfDeparture" />
<input type="submit" name="save">
</form>
</body>
</html>
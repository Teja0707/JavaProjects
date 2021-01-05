<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Your Reservation</title>
</head>
<body>
<pre>
Passenger first Name : ${reservation.passenger.firstName}
Passenger Last Name : ${reservation.passenger.lastName}
Passenger Email : ${reservation.passenger.email}
Passenger Phone : ${reservation.passenger.phone}
Flight ID : ${reservation.flight.flightNumber}
Reservation ID :  ${reservation.id}
Checked In : ${reservation.checkedIn}
Number of Bags : ${reservation.numberOfBags}
</pre>
</body>
</html>
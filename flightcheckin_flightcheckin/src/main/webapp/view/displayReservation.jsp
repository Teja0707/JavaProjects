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
<h1>Passenger Details</h1>
Passenger first Name : ${reservation.passenger.firstName}
Passenger Last Name : ${reservation.passenger.lastName}
Passenger Email : ${reservation.passenger.email}
Passenger Phone : ${reservation.passenger.phone}
<br/>
<br/>
<h1>Flight Details</h1>
Flight Number : ${reservation.flight.flightNumber}
Operating Airline : ${reservation.flight.operatingAirlines}
Departure City : ${reservation.flight.departureCity}
Arrival City : ${reservation.flight.arrivalCity}
Date of Departure : ${reservation.flight.dateOfDeparture}

Reservation ID :  ${reservation.id}
</pre>
<form action = "completeCheckIn" method = "post">
<pre>
Number of bags : <input type ="text" name="numberOfBags"/>

<input type="hidden" name="reservationId" value = "${reservation.id}"/>
<input type="submit" value="Checkin.">
</form>

</body>
</html>
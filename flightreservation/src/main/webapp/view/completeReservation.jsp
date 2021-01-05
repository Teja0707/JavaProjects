<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h3>Complete Reservation</h3>

 
<pre>
Flight Number : ${flight.flightNumber}
Operating Airlines : ${flight.operatingAirlines}
Departure City : ${flight.departureCity}
Arrival City :  ${flight.arrivalCity}
Date & Time Of Departure : ${flight.estimatedDepartureTime}
<hr/>
</pre>

   
<form action="completeReservation" method = "post">
<pre>
<h2>Passenger details</h2>
FIRST NAME : <input type ="text" name="passengerFirstName"/>

LAST NAME : <input type ="text" name="passengerLastName"/>

EMAIL : <input type ="text" name="passengerEmail"/>

PHONE : <input type ="text" name="passengerPhone"/>

<h2>Card details</h2>
Name on the card : <input type ="text" name="nameOnCard"/>
Card No : <input type ="text" name="cardNumber"/>
Expiry date : <input type ="text" name="expiryDate"/>
3 digit security code : <input type ="text" name="securityCode"/>

<input type="hidden" name="flightId" value="${flight.id}"/> 
<input type="submit" name="Confirm">
</pre>
</form> 

</body>
</html>
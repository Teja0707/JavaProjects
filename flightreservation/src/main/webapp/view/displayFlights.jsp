<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flights</title>
</head>
<body>
<h3>Flights</h3>
<table border="1">
  <tr>
    <th>Flight Number</th>
    <th>Operating Airlines</th>
    <th>Departure City</th>
    <th>Arrival City</th>
    <th>Date & Time Of Departure</th>
  </tr>
  <c:forEach var="flight" items="${flights}">
  <tr>
    <td>${flight.flightNumber}</td>
    <td>${flight.operatingAirlines}</td>
    <td>${flight.departureCity}</td>
    <td>${flight.arrivalCity}</td>
     <td>${flight.estimatedDepartureTime}</td>
    
    <td><a href="showCompleteReservation?id=${flight.id}" ><button>Select</button></a></td>
  </tr>
  </c:forEach>
</table>

</body>
</html>
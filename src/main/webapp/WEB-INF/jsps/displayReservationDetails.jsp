<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Reservation Details</title>
</head>
<body>
<h2>Flight Details</h2>
Airlines: ${reservation.flight.operatingAirlines}<br/>
Flight No: ${reservation.flight.flightNumber}<br/>
Departure City: ${reservation.flight.departureCity}<br/>
Arrival City: ${reservation.flight.arrivalCity}<br/>
Date Of Departure: ${reservation.flight.dateOfDeparture}<br/>
Estimated Departure Time: ${reservation.flight.estimatedDepartureTime}<br/>

<h2>Passenger Details</h2>
First Name: ${reservation.passenger.firstName}<br/>
Last Name: ${reservation.passenger.lastName}<br/>
Email: ${reservation.passenger.email}<br/>
Phone: ${reservation.passenger.phone}<br/>

<form action="completeCheckIn" method="post">
    Enter The Number Of Bags You Want to check in: <input type="text" name="numberOfBags"/>
    <input type="hidden" name="reservationId" value="${reservation.id}">
    <input type="submit" value="Check In">

</form>
</body>
</html>
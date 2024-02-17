package com.okwatch.flightcheckin.controllers;

import com.okwatch.flightcheckin.integration.ReservationRestClient;
import com.okwatch.flightcheckin.integration.dto.Reservation;
import com.okwatch.flightcheckin.integration.dto.ReservationUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CheckInController {
    @Autowired
    ReservationRestClient restClient;
    @RequestMapping("/showStartCheckIn")
    public String showStartCheckIn(){

        return "startCheckIn";
    }
    @RequestMapping("/startCheckIn")
    public String startCheckIn(@RequestParam("reservationId") Long reservationId, ModelMap modelMap){
        Reservation reservation = restClient.findReservation(reservationId);
        modelMap.addAttribute("reservation" ,reservation);
        return "displayReservationDetails";
    }
    @RequestMapping("/completeCheckIn")
    public String completeCheckIn(@RequestParam("reservationId") Long reservationId,@RequestParam("numberOfBags") Integer numberOfBags){
        ReservationUpdateRequest reservationUpdateRequest = new ReservationUpdateRequest();
        reservationUpdateRequest.setId(reservationId);
        reservationUpdateRequest.setCheckedIn(true);
        reservationUpdateRequest.setNumberOfBags(numberOfBags);
        restClient.updateReservation(reservationUpdateRequest);
        return "checkInConfirmation";
    }
}

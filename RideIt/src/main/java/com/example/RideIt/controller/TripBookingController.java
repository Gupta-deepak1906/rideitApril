package com.example.RideIt.controller;

import com.example.RideIt.dto.request.TripBookingRequest;
import com.example.RideIt.dto.response.TripBookingResponse;
import com.example.RideIt.service.TripBookingService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/trip")
@RequiredArgsConstructor//generated the constructor for final attributes

public class TripBookingController {
    private  final TripBookingService tripBookingService;
    //

    @PostMapping("/book")
    public ResponseEntity<TripBookingResponse> bookCab(@RequestParam(value = "apply-coupon",
            required = false,defaultValue = "false") boolean applyCoupon,
                                                       @RequestBody TripBookingRequest tripBookingRequest){
               TripBookingResponse response =tripBookingService.bookCab(applyCoupon,tripBookingRequest);
               return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}

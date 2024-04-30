package com.example.RideIt.controller;


import com.example.RideIt.dto.response.ExceptionResponse;
import com.example.RideIt.dto.response.Response;
import com.example.RideIt.dto.response.TripBookingResponse;
import com.example.RideIt.exception.CabNotAvailableException;
import com.example.RideIt.exception.CustomerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice//when we want to handle the exception globally then we use Controller Advice
public class AppControllerAdvice {
  //  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)//
    @ExceptionHandler({CustomerNotFoundException.class, CabNotAvailableException.class})

    public ResponseEntity<TripBookingResponse> handleException(Exception ex) {

        TripBookingResponse response = TripBookingResponse.builder()
                .message(ex.getMessage())
                .build();
        return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

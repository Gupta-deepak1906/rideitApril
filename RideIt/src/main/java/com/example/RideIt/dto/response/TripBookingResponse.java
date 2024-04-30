package com.example.RideIt.dto.response;

import com.example.RideIt.Enum.TripStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder

public class TripBookingResponse {

    String bookingId; //UUID
    String pickup;
    String destination;
    double tripDistanceInKm;
    double totalFare;
    TripStatus tripStatus;
    Date bookedAt;
    String message;
    CustomerResponse customerResponse;
  //  CustomerResponse customerResponse;
    DriverResponse driverResponse;
}

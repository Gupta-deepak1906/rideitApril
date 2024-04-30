package com.example.RideIt.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder

public class CabResponse {

    String cabNo;
    String carModel;
    //String carType;
    //int numberOfSeats;
    double farePerKm;
}

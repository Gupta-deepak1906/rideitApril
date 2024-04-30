package com.example.RideIt.dto.request;

import com.example.RideIt.Enum.CarType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)

public class CabRequest {
    String company;
    String carModel;
    CarType carType;
    int numberOfSeats;
    double farePerks;
}

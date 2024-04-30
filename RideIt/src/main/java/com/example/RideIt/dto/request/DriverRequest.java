package com.example.RideIt.dto.request;

import com.example.RideIt.model.Cab;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DriverRequest {

    String name;
    int age;
    String panNumber;
    String mobNo;
    CabRequest cab;
}

package com.example.RideIt.dto.request;

import com.example.RideIt.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerRequest {
    String name;
    int age;
    String mailId;
    String address;
    Gender gender;


}

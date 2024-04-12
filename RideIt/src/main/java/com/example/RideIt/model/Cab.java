package com.example.RideIt.model;

import com.example.RideIt.Enum.CarType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)


public class Cab {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String carModel;
    String company;
    @Enumerated(EnumType.STRING)
    CarType carType;
    int numberOfSeats;
    double farePerks;

}

package com.example.RideIt.model;

import com.example.RideIt.Enum.CarType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Cab {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String company;
    String carModel;

    boolean available;

    @Column(unique = true,nullable = false )
    String cabNo;

    @Enumerated(EnumType.STRING)
    CarType carType;
    int numberOfSeats;
    double farePerks;

    @OneToOne//first one one represent current class aand one represent driver class
            @JoinColumn(name="driver_id")
            @JsonIgnore
    Driver driver;


}

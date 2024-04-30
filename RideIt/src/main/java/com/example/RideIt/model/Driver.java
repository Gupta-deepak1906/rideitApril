package com.example.RideIt.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder


public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    int age;
    String panNumber;
    double rating;
    @Column(unique = true,nullable = false)
    String mobNo;
    @OneToOne(mappedBy = "driver",cascade = CascadeType.ALL)
    Cab cab;
    @OneToMany(mappedBy = "driver")
    List<TripBooking> bookings = new ArrayList<>();




}

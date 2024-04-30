package com.example.RideIt.model;

import com.example.RideIt.Enum.TripStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
//@Table(name="customer")
@Builder
public class TripBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String bookingId;//UUID
    String pickup;
    String destination;
    double tripDistanceInKm;
    double totalFare;
    TripStatus tripStatus;

    @CreationTimestamp
    Date bookedAt;

    @ManyToOne
            @JoinColumn
            @JsonIgnore
    Customer customer;

    @ManyToOne
    @JoinColumn
            @JsonIgnore
    Driver driver;


}

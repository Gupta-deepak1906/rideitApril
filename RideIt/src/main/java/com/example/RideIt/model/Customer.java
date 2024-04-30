package com.example.RideIt.model;

import com.example.RideIt.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)//making everything private
@Table(name="customer")
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    int age;
    @Column(unique = true,nullable = false)
    String emailId;
    String address;
    @Enumerated(EnumType.STRING)//store the data in springboot
    Gender gender;
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)//mapped by written in opposite to joined class

    List<TripBooking> bookings = new ArrayList<>();

}

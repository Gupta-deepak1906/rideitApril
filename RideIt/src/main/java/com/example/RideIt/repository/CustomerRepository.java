package com.example.RideIt.repository;

import com.example.RideIt.Enum.Gender;
import com.example.RideIt.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    //@Query(value = "select * from customer where gender = :gender and age >= :age",nativeQuery = true)//sql
    //nativeQuery=normal Sequence querires
    @Query(value = "select c from Customer c where c.gender = :gender and c.age >= :age")//hql

    List<Customer> getByGenderAndAgeGreaterThan(Gender gender, int age);

    Customer findByEmailId(String  emailID);
}

package com.example.RideIt.service;

import com.example.RideIt.Enum.Gender;
import com.example.RideIt.dto.request.CustomerRequest;
import com.example.RideIt.dto.response.CustomerResponse;
import com.example.RideIt.model.Customer;
import com.example.RideIt.repository.CustomerRepository;
import com.example.RideIt.transformer.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public CustomerResponse addCustomer(CustomerRequest customerRequest) {
        //first step convert dto to entity
      //  Customer customer = new Customer();
       // customer.setName(customerRequest.getName());
        //customer.setAge(customerRequest.getAge());
        //customer.setEmailID(customerRequest.getMailId());
        //customer.setAddress(customerRequest.getAddress());
        //customer.setGender(customerRequest.getGender());


      //  Customer customer=Customer.builder()
        //        .name(customerRequest.getName())
          //      .age(customerRequest.getAge())
            //    .address(customerRequest.getAddress())
              //  .emailID(customerRequest.getMailId())
                //.gender(customerRequest.getGender())
                //.build();

        Customer customer = CustomerTransformer.customerRequestToCustomer(customerRequest);

        //save the customer
        Customer savedCustomer = customerRepository.save(customer);
        //converted entity into response dto
    //   return CustomerResponse.builder()
      //          .name(savedCustomer.getName())
        //        .mailId(savedCustomer.getEmailID())
          //      .build();
        //entity to response dto
        return CustomerTransformer.customerToCustomerResponse(savedCustomer);
        //return "Customer saved successfully!!";
    }

    public List<CustomerResponse> getCustomerByGenderAndAgeGreaterThan(Gender gender, int age) {
        List<Customer> customers = customerRepository.getByGenderAndAgeGreaterThan(gender, age);

        List<CustomerResponse> customerResponses = new ArrayList<>();
        for(Customer customer:customers){
            customerResponses.add(CustomerTransformer.customerToCustomerResponse(customer));//doubt
          //  CustomerResponse customerResponse = CustomerTransformer.customerToCustomerRequest(customer);
            //customerResponse.add(customerResponse);
        }
        return customerResponses;
    }
}

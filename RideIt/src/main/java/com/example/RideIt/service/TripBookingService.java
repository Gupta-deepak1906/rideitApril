package com.example.RideIt.service;


import com.example.RideIt.dto.request.TripBookingRequest;
import com.example.RideIt.dto.response.TripBookingResponse;
import com.example.RideIt.exception.CabNotAvailableException;
import com.example.RideIt.exception.CustomerNotFoundException;
import com.example.RideIt.model.Cab;
import com.example.RideIt.model.Customer;
import com.example.RideIt.model.TripBooking;
import com.example.RideIt.repository.CabRepository;
import com.example.RideIt.repository.CustomerRepository;
import com.example.RideIt.repository.DriverRepository;
import com.example.RideIt.repository.TripBookingRepository;
import com.example.RideIt.transformer.BookingTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TripBookingService {


    private final CustomerRepository customerRepository;
    private final CabRepository cabRepository;
    private DriverRepository driverRepository;
    private TripBookingRepository tripBookingRepository;


   // private final JavaMailSender javaMailSender;
    @Autowired
    JavaMailSender javaMailSender;
    public TripBookingResponse bookCab(boolean applyCoupon,
                                       TripBookingRequest tripBookingRequest) throws CabNotAvailableException {
        //validate email id of the customer
        Customer customer = customerRepository.findByEmailId(tripBookingRequest.getCustomerEmailId());
        if(customer==null){
            throw new CustomerNotFoundException("Invalid email id");
        }
        // check if cab is available or not for booking
        // get a random available cab
        Cab cab = cabRepository.getRandomAvailableCab();
        if(cab==null){
            throw new CabNotAvailableException("Sorry! All drivers are busy right now!!");
        }

    //prepare for booking entity
        TripBooking tripBooking= BookingTransformer.bookingRequestToBooking(tripBookingRequest);
        tripBooking.setTotalFare(cab.getFarePerks()* tripBookingRequest.getTripDistanceInKm());

        tripBooking.setCustomer(customer);
        tripBooking.setDriver(cab.getDriver());

        TripBooking savedTripBooking = tripBookingRepository.save(tripBooking);


        customer.getBookings().add(savedTripBooking );
      //  Customer savedCustomer = customerRepository.save(customer);//save both customer & booking
        cab.setAvailable(false);

        cab.getDriver().getBookings().add(savedTripBooking);
        //customer & booking got saved
        customerRepository.save(customer);

        customerRepository.save(customer);//customer & booking get saved because of cascading
        driverRepository.save(cab.getDriver());//driver +cab + booking
       // return null;

        //sending mail
        sendEmail(savedTripBooking);

        //last step-> prepare booking response
        return BookingTransformer.tripBookingToTripBookingResponse(savedTripBooking);

    }

    private void sendEmail(TripBooking savedTripBooking) {
      //prepare your email
        String text = "Congrats!!" + savedTripBooking.getCustomer().getName()
                + "your ride is booked with" + savedTripBooking.getDriver().getName();
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("write email name");
        simpleMailMessage.setTo(savedTripBooking.getCustomer().getEmailId());
        simpleMailMessage.setSubject("Cab Booked!!");
        simpleMailMessage.setText(text);


        //send the mail
        javaMailSender.send(simpleMailMessage);

    }
}

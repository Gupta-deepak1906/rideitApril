package com.example.RideIt.service;

import com.example.RideIt.dto.request.CabRequest;
import com.example.RideIt.dto.request.DriverRequest;
import com.example.RideIt.model.Cab;
import com.example.RideIt.model.Driver;
import com.example.RideIt.repository.DriverRepository;
import com.example.RideIt.transformer.CabTransformer;
import com.example.RideIt.transformer.DriverTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor
public class DriverService {
    @Autowired
    DriverRepository driverRepository;


    public String adddriver(DriverRequest driverRequest) {
        CabRequest cabRequest = driverRequest.getCab();

        //convert driver request to driver
        //convert cabRequest to cab
        Driver driver  = DriverTransformer.driverRequestToDriver(driverRequest);
        Cab cab = CabTransformer.cabRequestToCab(driverRequest.getCab());

        //set the relationship attributes
        driver.setCab(cab);
        cab.setDriver(driver);
        driverRepository.save(driver);//save both driver and cab
        return "Driver and  Cab saved successfuly";

    }

    public Driver getDriver(String mobNo) {
        return driverRepository.findByMobNo(mobNo);
    }


}

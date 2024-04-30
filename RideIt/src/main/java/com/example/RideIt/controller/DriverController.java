package com.example.RideIt.controller;

import com.example.RideIt.dto.request.DriverRequest;
import com.example.RideIt.model.Driver;
import com.example.RideIt.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/driver")
public class DriverController {
   // @Autowired
    //DriverService driverService;
    private final DriverService driverService;
    public DriverController(DriverService driverService){
        this.driverService=driverService;
    }
    public ResponseEntity<String> addDriver(@RequestBody DriverRequest driverRequest){
        String response = driverService.adddriver(driverRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    //delete a driver by mob no,(don't manually get the cab)

    @GetMapping("/mob-no/{mob-no}")
    public Driver getDriver(@RequestParam("mob") String mobNo){
        return driverService.getDriver(mobNo);
    }
}

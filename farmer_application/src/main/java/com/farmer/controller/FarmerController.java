package com.farmer.controller;

import com.farmer.dto.FarmerDTO;
import com.farmer.dto.ServiceDTO;
import com.farmer.service.FarmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FarmerController {
    @Autowired
    private FarmerService farmerService;

    @GetMapping("/getFarmers")
    public ServiceDTO getFarmers() {
        return farmerService.getFarmers();
    }

    @GetMapping("/getFarmers/{farmerId}")
    public ServiceDTO getFarmer(@PathVariable final Long farmerId) {
        return farmerService.findFarmerByID(farmerId);
    }

    @PostMapping("/saveFarmer")
    public FarmerDTO saveFarmer(@RequestBody FarmerDTO farmerDTO) {
        return farmerService.saveFarmer(farmerDTO);
    }
}

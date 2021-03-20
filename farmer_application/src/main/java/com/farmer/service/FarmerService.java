package com.farmer.service;

import com.farmer.dto.FarmerDTO;
import com.farmer.dto.ServiceDTO;

import java.util.List;

public interface FarmerService {
    ServiceDTO getFarmers();

    ServiceDTO findFarmerByID(Long farmerID);

    FarmerDTO saveFarmer(FarmerDTO farmerDTO);
}

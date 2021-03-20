package com.farmer.service.impl;

import com.farmer.dto.ErrorDTO;
import com.farmer.dto.FarmerDTO;
import com.farmer.dto.FarmerDataDTO;
import com.farmer.dto.ServiceDTO;
import com.farmer.entities.FarmerDetails;
import com.farmer.repository.FarmerRepository;
import com.farmer.service.FarmerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FarmerServiceImpl implements FarmerService {

    private static final Logger LOG = LogManager.getLogger(FarmerServiceImpl.class);
    @Autowired
    private FarmerRepository farmerRepository;

    @Override
    public ServiceDTO getFarmers() {

        final List<FarmerDTO> listOfFarmers = new ArrayList<>();

        try {
            for (FarmerDetails farmerDetails : farmerRepository.findAll()) {
                final FarmerDTO farmersDTO = new FarmerDTO();
                BeanUtils.copyProperties(farmerDetails, farmersDTO);
                listOfFarmers.add(farmersDTO);
            }
            FarmerDataDTO farmerDataDTO = new FarmerDataDTO();
            farmerDataDTO.setListOfFarmerDTO(listOfFarmers);
            ServiceDTO serviceDTO = new ServiceDTO();
            serviceDTO.setMessage("SUCCESS");
            serviceDTO.setPayload(farmerDataDTO);
            return serviceDTO;
        } catch (Exception exception) {
            ErrorDTO errorDTO = new ErrorDTO();
            errorDTO.setErrorName("No Data found");
            errorDTO.setErrorType("Plz Insert Data");
            ServiceDTO serviceDTO = new ServiceDTO();
            serviceDTO.setMessage("FAILURE");
            serviceDTO.setErrorDTO(errorDTO);
            return serviceDTO;
        }
    }

    public ServiceDTO findFarmerByID(Long farmerId) {

        Optional<FarmerDetails> farmerDetails = farmerRepository.findById(farmerId);
        FarmerDTO farmerDTO = new FarmerDTO();
        ServiceDTO serviceDTO = new ServiceDTO();
        try {
            BeanUtils.copyProperties(farmerDetails.get(), farmerDTO);
            serviceDTO.setMessage("SUCCESS");
            serviceDTO.setPayload(farmerDTO);
            return serviceDTO;

        } catch (Exception exception) {
            ErrorDTO errorDTO = new ErrorDTO();
            errorDTO.setErrorName("No Details on that id");
            errorDTO.setErrorType("Plz Enter Valid FarmerId");
            serviceDTO.setMessage("FAILURE");
            serviceDTO.setErrorDTO(errorDTO);
            LOG.error("FarmerServiceImpl---findFarmerByID()---Not registered Farmer");
            return serviceDTO;
        }
    }

    @Override
    public FarmerDTO saveFarmer(FarmerDTO farmerDTO) {
        FarmerDetails farmerDetails = new FarmerDetails();

        BeanUtils.copyProperties(farmerDTO, farmerDetails);
        farmerDetails = farmerRepository.save(farmerDetails);
        BeanUtils.copyProperties(farmerDetails, farmerDTO);
        return farmerDTO;
    }
}

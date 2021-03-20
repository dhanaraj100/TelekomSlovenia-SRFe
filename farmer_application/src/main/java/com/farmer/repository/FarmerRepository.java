package com.farmer.repository;

import com.farmer.entities.FarmerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FarmerRepository extends JpaRepository<FarmerDetails, Long> {

}

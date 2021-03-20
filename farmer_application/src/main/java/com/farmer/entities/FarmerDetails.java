package com.farmer.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FarmerDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long farmerId;
    private String farmerName;
    private Long phoneNumber;
    private String mailId;
    private String password;

    public Long getFarmerId() {
        return farmerId;
    }

    @Override
    public String toString() {
        return "FarmerDetails{" +
                "farmerId=" + farmerId +
                ", farmerName='" + farmerName + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", mailId='" + mailId + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public void setFarmerId(Long farmerId) {
        this.farmerId = farmerId;
    }

    public String getFarmerName() {
        return farmerName;
    }

    public void setFarmerName(String farmerName) {
        this.farmerName = farmerName;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

package com.example.insurancecard.dto;

import com.example.insurancecard.entity.Account;
import com.example.insurancecard.entity.MotorBike;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
public class MotorBikeDto {

    private long id;
    private String license;
    private String model;
    private String manufacturer;
    private String color;
    private Date MFG;
    private String frameNumber;
    private String engineNumber;
    private String image;

    private AccountDto accountDto;

    public MotorBikeDto(MotorBike motorBike){
        this.setId(motorBike.getId());
        this.setLicense(motorBike.getLicense());
        this.setModel(motorBike.getModel());
        this.setManufacturer(motorBike.getManufacturer());
        this.setColor(motorBike.getColor());
        this.setMFG(motorBike.getMFG());
        this.setFrameNumber(motorBike.getFrameNumber());
        this.setEngineNumber(motorBike.getEngineNumber());
        this.setImage(motorBike.getImage());

        if (null != motorBike.getAccount()){
            accountDto = new AccountDto(motorBike.getAccount());
        }
    }


}

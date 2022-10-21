package com.example.insurancecard.controller;

import com.example.insurancecard.dto.MotorBikeDto;
import com.example.insurancecard.service.MotorBikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/motorbike")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MotorbikeController {
    @Autowired
    private MotorBikeService service;
    @Value("${upload.path}")
    private String fileUpload;

    @PostMapping(value = "/add")
    public ResponseEntity<MotorBikeDto> create(@RequestBody MotorBikeDto motorBikeDto, @RequestParam MultipartFile file){
        String fileName = file.getOriginalFilename();
        try {
            FileCopyUtils.copy(file.getBytes(), new File(this.fileUpload + fileName));
        }catch (IOException e){
            e.printStackTrace();
        }
        motorBikeDto.setImage(fileName);
        MotorBikeDto motorBike = service.save(motorBikeDto);
        return new ResponseEntity<>(motorBike, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<List<MotorBikeDto>> getAll(){
        List<MotorBikeDto> list = service.getAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}

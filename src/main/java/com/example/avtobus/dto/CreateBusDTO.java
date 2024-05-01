package com.example.avtobus.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateBusDTO {
    private String name;
    private String number;
    private String startAddress;
    private Integer placesNumber;
    private String endAddress;
    private String  WalkTime;
    private Double price;
}

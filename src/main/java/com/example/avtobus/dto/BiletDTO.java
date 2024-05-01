package com.example.avtobus.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BiletDTO{
    private String startAddress;
    private String endAddress;
    private Date walkTime;
}

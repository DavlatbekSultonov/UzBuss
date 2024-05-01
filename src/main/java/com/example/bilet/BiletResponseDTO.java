package com.example.bilet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BiletResponseDTO {
    private Integer id;
    private String clientName;
    private String  departureDate;
    private Integer seatNumber;
    private Double price;
}

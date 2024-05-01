package com.example.avtobus.entity;

import com.example.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "'avtobus'")
public class Avtobus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String name;
    private String number;
    private String startAddress;
    private Integer placesNumber;
    private String endAddress;
    private String WalkTime;
    private Double price;
    @OneToMany(mappedBy = "avtobus", cascade = CascadeType.ALL)
    private List<User> userList;
}
package com.example.demo.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Data
@EqualsAndHashCode
public class Vehicle implements Serializable {

    public Vehicle(){}

    public Vehicle(String id, String type){
        this.type = type;
        this.id = id;
    }

    @Id
    private String id;

    private String type;

    private String modelCode;

    private String brandName;

}

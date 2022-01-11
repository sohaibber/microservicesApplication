package com.example.customerservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class CustomerRequestDto {

    private Long id;
    private String name;
    private String email;
}

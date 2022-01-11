package com.example.customerservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class CustomerResponseDto {

    private Long id;
    private String name;
    private String email;

}

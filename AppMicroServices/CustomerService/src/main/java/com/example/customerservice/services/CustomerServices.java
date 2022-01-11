package com.example.customerservice.services;

import com.example.customerservice.dto.CustomerRequestDto;
import com.example.customerservice.dto.CustomerResponseDto;
import com.example.customerservice.entities.Customer;

import java.util.Collection;
import java.util.List;


public interface CustomerServices {
    CustomerResponseDto save(CustomerRequestDto crd);
    CustomerResponseDto getCustomer(Long id);
    CustomerResponseDto update(CustomerRequestDto crd);
    List<CustomerResponseDto> listCutomers();
}

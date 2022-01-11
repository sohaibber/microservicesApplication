package com.example.customerservice.mappers;

import com.example.customerservice.dto.CustomerRequestDto;
import com.example.customerservice.dto.CustomerResponseDto;
import com.example.customerservice.entities.Customer;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel= "spring")
public interface CustomerMapper {
    CustomerResponseDto customerToCustomerResponseDto(Customer customer);
    Customer customerRequestDtoToCustomer(CustomerRequestDto customerRequestDto);
}

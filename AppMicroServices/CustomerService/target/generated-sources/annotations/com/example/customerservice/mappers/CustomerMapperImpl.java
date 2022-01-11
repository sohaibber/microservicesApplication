package com.example.customerservice.mappers;

import com.example.customerservice.dto.CustomerRequestDto;
import com.example.customerservice.dto.CustomerResponseDto;
import com.example.customerservice.entities.Customer;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-11T03:33:37+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_281 (Oracle Corporation)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerResponseDto customerToCustomerResponseDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerResponseDto customerResponseDto = new CustomerResponseDto();

        customerResponseDto.setId( customer.getId() );
        customerResponseDto.setName( customer.getName() );
        customerResponseDto.setEmail( customer.getEmail() );

        return customerResponseDto;
    }

    @Override
    public Customer customerRequestDtoToCustomer(CustomerRequestDto customerRequestDto) {
        if ( customerRequestDto == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setId( customerRequestDto.getId() );
        customer.setName( customerRequestDto.getName() );
        customer.setEmail( customerRequestDto.getEmail() );

        return customer;
    }
}

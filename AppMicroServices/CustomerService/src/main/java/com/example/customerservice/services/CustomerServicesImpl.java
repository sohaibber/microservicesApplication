package com.example.customerservice.services;

import com.example.customerservice.dto.CustomerRequestDto;
import com.example.customerservice.dto.CustomerResponseDto;
import com.example.customerservice.entities.Customer;
import com.example.customerservice.mappers.CustomerMapper;
import com.example.customerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerServicesImpl implements CustomerServices {
    @Autowired
    private CustomerRepository cr;
    @Autowired
    private CustomerMapper customerMapper;


    @Override
    public CustomerResponseDto save(CustomerRequestDto crd) {

        Customer customer=customerMapper.customerRequestDtoToCustomer(crd);
        Customer savedCustomer= cr.save(customer);
        return customerMapper.customerToCustomerResponseDto(savedCustomer);
    }

    @Override
    public CustomerResponseDto getCustomer(Long id) {
        Customer customer=cr.findById(id).get();


        return customerMapper.customerToCustomerResponseDto(customer);
    }

    @Override
    public CustomerResponseDto update(CustomerRequestDto crd) {
        Customer customer=customerMapper.customerRequestDtoToCustomer(crd);
        Customer savedCustomer= cr.save(customer);
        return customerMapper.customerToCustomerResponseDto(savedCustomer);
    }

    @Override
    public List<CustomerResponseDto> listCutomers() {
        List<Customer> customers=cr.findAll();
        List<CustomerResponseDto> customerResponseDtos=customers.stream().map(c -> customerMapper.customerToCustomerResponseDto(c))
                .collect(Collectors.toList());
        return customerResponseDtos;
    }
}

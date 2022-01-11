package com.example.customerservice.web;

import com.example.customerservice.dto.CustomerRequestDto;
import com.example.customerservice.dto.CustomerResponseDto;
import com.example.customerservice.services.CustomerServices;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    private CustomerServices customerServices;

    public CustomerController(CustomerServices customerServices) {
        this.customerServices = customerServices;
    }

    @PostMapping( path = "/addCustomer")
    public CustomerResponseDto save(@RequestBody CustomerRequestDto crd){
        return customerServices.save(crd);
    }
    @PutMapping(path = "/updateCustomer")
    public CustomerResponseDto update(@RequestBody CustomerRequestDto crd){
        return customerServices.save(crd);
    }
    @GetMapping(path = "/customers")
    public List <CustomerResponseDto> getCustomers(){
        return customerServices.listCutomers();
    }

    @GetMapping(path = "/customers/{id}")
    public CustomerResponseDto getOneCustomer(@PathVariable Long id){
        return customerServices.getCustomer(id);
    }
}

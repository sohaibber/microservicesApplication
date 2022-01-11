package com.example.billservice.web;

import com.example.billservice.dto.BillRequestDTO;
import com.example.billservice.dto.BillResponseDTO;
import com.example.billservice.entities.Bill;
import com.example.billservice.feign.CustomerRestClient;
import com.example.billservice.feign.ProductItemRestClient;
import com.example.billservice.repository.BillRepository;
import com.example.billservice.repository.ProductItemRepository;
import com.example.billservice.services.BillServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BillController {
    BillRepository br;
    ProductItemRepository pr;
    CustomerRestClient cr;
    ProductItemRestClient prc;
    private BillServices billServices;


    public BillController(BillServices billServices,BillRepository br, ProductItemRepository pr, CustomerRestClient cr, ProductItemRestClient prc) {
        this.br = br;
        this.pr = pr;
        this.cr = cr;
        this.prc = prc;
        this.billServices = billServices;
    }


    @GetMapping(path = "/bill/{id}")
    public BillResponseDTO getBill(@PathVariable Long id){
        return billServices.getBill(id);
    }

    @GetMapping(path = "/bills")
    public List<BillResponseDTO> getBills(){
        return billServices.getBills();
    }

    @GetMapping(path = "/billsByCustomer/{id}")
    public List<BillResponseDTO> getBillofCustomer(@PathVariable Long customerID){
        return billServices.getBillsByCustomerID(customerID);
    }
    @PostMapping(path = "/bills")
    public BillResponseDTO addBills(@RequestBody BillRequestDTO billRequestDTO){
        return billServices.save(billRequestDTO);
    }
}

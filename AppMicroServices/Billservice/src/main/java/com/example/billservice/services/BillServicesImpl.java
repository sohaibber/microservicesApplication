package com.example.billservice.services;

import com.example.billservice.dto.BillRequestDTO;
import com.example.billservice.dto.BillResponseDTO;
import com.example.billservice.entities.Bill;
import com.example.billservice.feign.CustomerRestClient;
import com.example.billservice.mappers.BillMapper;
import com.example.billservice.model.Customer;
import com.example.billservice.repository.BillRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BillServicesImpl implements BillServices {

    private BillRepository billRepository;
    private BillMapper billMapper;
    private CustomerRestClient customerRestClient;

    public BillServicesImpl(BillRepository billRepository, BillMapper billMapper, CustomerRestClient customerRestClient) {
        this.billRepository = billRepository;
        this.billMapper = billMapper;
        this.customerRestClient = customerRestClient;
    }

    @Override
    public BillResponseDTO save(BillRequestDTO billRequestDTO) {
        Bill bill=billMapper.fromBillRequestDTO(billRequestDTO);
        Bill savedBill=billRepository.save(bill);
        Customer customer=customerRestClient.getCustomerById(bill.getCustomerID());
        savedBill.setCustomer(customer);
        return  billMapper.fromBill(savedBill);
    }

    @Override
    public BillResponseDTO getBill(Long id) {
        Bill bill=billRepository.findById(id).get();
        Customer customer=customerRestClient.getCustomerById(bill.getCustomerID());
        bill.setCustomer(customer);
        return  billMapper.fromBill(bill);
    }

    @Override
    public List<BillResponseDTO> getBillsByCustomerID(Long customerID) {
        Collection<Bill> bills=billRepository.findBillByCustomerID(customerID);
        List<BillResponseDTO> billResponseDTOS=bills.stream().map(b -> billMapper.fromBill(b))
                .collect(Collectors.toList());
        return billResponseDTOS;
    }

    @Override
    public List<BillResponseDTO> getBills() {
        List<Bill> bills=billRepository.findAll();
        bills.forEach(b -> {
            Customer customer=customerRestClient.getCustomerById(b.getCustomerID());
            b.setCustomer(customer);
        });
        List<BillResponseDTO> billResponseDTOS= bills.stream().map(b -> billMapper.fromBill(b))
                .collect(Collectors.toList());

        return billResponseDTOS;
    }

}

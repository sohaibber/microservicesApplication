package com.example.billservice.services;

import com.example.billservice.dto.BillRequestDTO;
import com.example.billservice.dto.BillResponseDTO;
import com.example.billservice.entities.Bill;

import java.util.List;

public interface BillServices {
    BillResponseDTO save(BillRequestDTO billRequestDTO);
    BillResponseDTO getBill(Long id);
    List<BillResponseDTO> getBillsByCustomerID(Long customerID);
    List<BillResponseDTO> getBills();
}

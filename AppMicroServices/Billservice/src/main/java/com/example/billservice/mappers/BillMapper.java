package com.example.billservice.mappers;

import com.example.billservice.dto.BillRequestDTO;
import com.example.billservice.dto.BillResponseDTO;
import com.example.billservice.entities.Bill;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BillMapper {

    Bill fromBillRequestDTO(BillRequestDTO billRequestDTO);
    BillResponseDTO fromBill(Bill bill);
}

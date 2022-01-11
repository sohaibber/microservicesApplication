package com.example.billservice.mappers;

import com.example.billservice.dto.BillRequestDTO;
import com.example.billservice.dto.BillResponseDTO;
import com.example.billservice.entities.Bill;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-10T21:33:22+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_281 (Oracle Corporation)"
)
@Component
public class BillMapperImpl implements BillMapper {

    @Override
    public Bill fromBillRequestDTO(BillRequestDTO billRequestDTO) {
        if ( billRequestDTO == null ) {
            return null;
        }

        Bill bill = new Bill();

        bill.setId( billRequestDTO.getId() );
        bill.setBillingDate( billRequestDTO.getBillingDate() );
        bill.setAmount( billRequestDTO.getAmount() );
        bill.setCustomerID( billRequestDTO.getCustomerID() );

        return bill;
    }

    @Override
    public BillResponseDTO fromBill(Bill bill) {
        if ( bill == null ) {
            return null;
        }

        BillResponseDTO billResponseDTO = new BillResponseDTO();

        billResponseDTO.setId( bill.getId() );
        billResponseDTO.setBillingDate( bill.getBillingDate() );
        billResponseDTO.setAmount( bill.getAmount() );
        billResponseDTO.setCustomer( bill.getCustomer() );

        return billResponseDTO;
    }
}

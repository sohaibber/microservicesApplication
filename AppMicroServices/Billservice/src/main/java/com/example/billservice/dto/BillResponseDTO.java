package com.example.billservice.dto;


import com.example.billservice.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BillResponseDTO {
    private Long id;
    private Date billingDate;
    private BigDecimal amount;
    private Customer customer;
}

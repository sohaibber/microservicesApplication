package com.example.billservice.repository;

import com.example.billservice.entities.Bill;
import com.example.billservice.entities.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

@RepositoryRestResource
public interface BillRepository extends JpaRepository<Bill, Long> {
    public Collection<ProductItem> findBillById(Long id);
    public Collection<Bill> findBillByCustomerID(Long id);

}

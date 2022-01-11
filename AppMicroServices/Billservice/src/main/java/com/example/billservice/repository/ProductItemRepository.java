package com.example.billservice.repository;

import com.example.billservice.entities.Bill;
import com.example.billservice.entities.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProductItemRepository extends JpaRepository<ProductItem, Long> {
}

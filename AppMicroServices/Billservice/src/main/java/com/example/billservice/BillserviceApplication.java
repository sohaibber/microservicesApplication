package com.example.billservice;

import com.example.billservice.dto.BillRequestDTO;
import com.example.billservice.dto.BillResponseDTO;
import com.example.billservice.entities.Bill;
import com.example.billservice.entities.ProductItem;
import com.example.billservice.feign.CustomerRestClient;
import com.example.billservice.feign.ProductItemRestClient;
import com.example.billservice.model.Customer;
import com.example.billservice.model.Product;
import com.example.billservice.repository.BillRepository;
import com.example.billservice.repository.ProductItemRepository;
import com.example.billservice.services.BillServices;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.PagedModel;

import java.math.BigDecimal;
import java.util.Date;

@SpringBootApplication
@EnableFeignClients
public class BillserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillserviceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(BillServices billServices,BillRepository br, CustomerRestClient cr){
		return args -> {
			//Customer customer=cr.getCustomerById(1L);
			BillResponseDTO bill=billServices.save(new BillRequestDTO(null,new Date(),new BigDecimal(3333),1L));


		};
	}

}

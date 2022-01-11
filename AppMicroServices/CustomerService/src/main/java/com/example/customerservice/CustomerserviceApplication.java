package com.example.customerservice;

import com.example.customerservice.dto.CustomerRequestDto;
import com.example.customerservice.entities.Customer;
import com.example.customerservice.repository.CustomerRepository;
import com.example.customerservice.services.CustomerServices;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CustomerserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerserviceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(CustomerServices cs,CustomerRepository cr, RepositoryRestConfiguration repositoryRestConfiguration){
		repositoryRestConfiguration.exposeIdsFor(Customer.class);

		return args -> {
			cs.save(new CustomerRequestDto(null,"Sohaib1","Sohaib@gmail.com"));
			cs.save(new CustomerRequestDto(null,"Sohaib2","Sohaib2@gmail.com"));
			cs.save(new CustomerRequestDto(null,"Sohaib3","Sohaib3@gmail.com"));
			cr.findAll().forEach(c->{
				System.out.println(c);
			});
		};
	}

}

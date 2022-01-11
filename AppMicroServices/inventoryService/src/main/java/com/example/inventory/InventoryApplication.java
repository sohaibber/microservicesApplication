package com.example.inventory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@SpringBootApplication
public class InventoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ProductRepository pr, RepositoryRestConfiguration repositoryRestConfiguration) {
		repositoryRestConfiguration.exposeIdsFor(Product.class);
		return args -> {
			pr.save(new Product(null, "Ordinateur", 6778, 2));
			pr.save(new Product(null, "mobile", 9978, 3));
			pr.save(new Product(null, "imprimante", 7778, 4));

			pr.findAll().forEach(c -> {
				System.out.println(c.getName());
			});
		};

	}
}

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
class Product{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private double price;
	private double quantity;
}

@RepositoryRestResource
interface ProductRepository extends JpaRepository<Product, Long> {

}

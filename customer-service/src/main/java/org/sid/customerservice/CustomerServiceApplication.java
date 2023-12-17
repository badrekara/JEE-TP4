package org.sid.customerservice;

import org.sid.customerservice.entities.Customer;
import org.sid.customerservice.repo.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerRepository customerRepository){
		return args ->{
			customerRepository.saveAll(List.of(
					Customer.builder().name("Kara").email("kara@gmail.com").build(),
					Customer.builder().name("Ladnany").email("ladnany@gmail.com").build(),
					Customer.builder().name("Oufrout").email("oufrout@gmail.com").build()
			));
			customerRepository.findAll().forEach(System.out::println);
		};
	}

}

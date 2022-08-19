package com.example.springbootrestapi;

import com.example.springbootrestapi.model.Employee;
import com.example.springbootrestapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestApiApplication.class, args);

		System.out.println("Abdus Samad");

	}

}

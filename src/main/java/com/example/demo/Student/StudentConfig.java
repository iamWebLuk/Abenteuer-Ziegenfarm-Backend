package com.example.demo.Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

	@Bean
	CommandLineRunner commandLineRunner(StudentRepository repository) {
		return args -> {
			Student mariam = new Student("Mariam", LocalDate.of(1992, Month.DECEMBER,22),"marian.jamal@gmx.at");

			Student alex = new Student("alex", LocalDate.of(2002,Month.JANUARY, 12), "alex@gmail.com");

		repository.saveAll(List.of(mariam,alex));
		};
	}
}

package com.example.demo.Student;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Student {

	@Id
	@SequenceGenerator(name="student_sequence",
			sequenceName = "student_sequence",
			allocationSize = 1)

	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "student_sequence"
	)
	private Long id;
	private String name;
	@Transient
	private Integer age;
	private LocalDate dateOfBirth;
	private String email;

	public Student() {
	}

	public Student(String name, LocalDate dateOfBirth, String email) {
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
	}

	public Student(Long id, String name, LocalDate dateOfBirth, String email) {
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return Period.between(this.dateOfBirth, LocalDate.now()).getYears();
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}

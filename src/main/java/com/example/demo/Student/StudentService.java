package com.example.demo.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

	private final StudentRepository studentRepository;

	@Autowired
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public List<Student> getStudent() {
		return studentRepository.findAll();
	}

	public void addNewStudent(Student student) {
		Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());

		if (studentOptional.isPresent()) {
			throw new IllegalStateException("email taken");
		}
		studentRepository.save(student);
		System.out.println(student);
	}

	public void deleteStudent(Long studentId) {


		boolean exists = studentRepository.existsById(studentId);

		if (!exists) {
			throw new IllegalStateException("There is no student with this id");
		}
		studentRepository.deleteById(studentId);
	}

	@Transactional
	public void updateStudent(Long id, String name, String email) {

		Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalStateException("no id"));
		System.out.println(student.getEmail());

			if (name != null && name.length() > 0 && !Objects.equals(student.getName(), name)) {
				student.setName(name);
			}
			if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {
				Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);

				if (studentOptional.isPresent()) {
					throw new IllegalStateException("this email already exists");
				}
				student.setEmail(email);
			}
		studentRepository.save(student);
	}

}


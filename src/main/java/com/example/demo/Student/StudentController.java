package com.example.demo.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

	private final StudentService studentService;

	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@GetMapping("/moxis")
	public List<String> hello() {
		return List.of("Hello", "World");
	}

	@GetMapping("/student")
	public List<Student> getStudent() {
		return studentService.getStudent();
	}

	@PostMapping
	public void registerNewStudent(@RequestBody Student student) {
		studentService.addNewStudent(student);
	}

	@DeleteMapping(path = "{studentId}")
	public void deleteStudent(@PathVariable(value = "studentId") Long id) {
		studentService.deleteStudent(id);
		System.out.println("you deleted a student");
	}

	@PostMapping(path = "{studentId}")
	public void updateStudent(@PathVariable Long studentId, @RequestParam(required = false) String name, @RequestParam(required = false) String email) {
		studentService.updateStudent(studentId, name, email);
		System.out.println("you update a student");
	}

}

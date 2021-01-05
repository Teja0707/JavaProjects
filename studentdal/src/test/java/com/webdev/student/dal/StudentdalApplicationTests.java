package com.webdev.student.dal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.webdev.student.dal.entities.Student;
import com.webdev.student.dal.repos.StudentRepository;

@SpringBootTest
class StudentdalApplicationTests {

	@Autowired
	private StudentRepository studentRepository;
	
	@Test
	public void testCreateStudent() {
		
		Student student = new Student();
		student.setName("Teja");
		student.setCourse("Java");
		student.setFee(100.0);
		
		
		studentRepository.save(student);
	}
	
	@Test
	public void testReadStudent() {
		
		Student student = studentRepository.findById(1).get();
		System.out.println(student);
		
	}
	
	@Test
	public void testUpdateStudent() {
		
		Student student = studentRepository.findById(1).get();
		student.setFee(80.0);
		studentRepository.save(student);
			
		
	}
	
	@Test
	public void testDeleteStudent() {
		
		studentRepository.deleteById(1);
			
		
	}

}

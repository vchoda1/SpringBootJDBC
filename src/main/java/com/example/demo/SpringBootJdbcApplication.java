package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.dao.StudentDAO;
import com.example.demo.model.Student;

@SpringBootApplication
public class SpringBootJdbcApplication implements CommandLineRunner {
	
	@Autowired
	private StudentDAO studentDAO;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//createStudent();
		//getStudent();
		studentDAO.deleteStudentById(1);
		
	}

	private void createStudent() {
		Student student = new Student();
		student.setStudentId(2);
		student.setStudentName("vchoda");
		student.setStudentAddress("50164,MD");
		
		studentDAO.createStudent(student);
		
	}
	
   private void getStudent(){
	   Student student = studentDAO.getStudentById(1);
	   System.out.println(student);
	   
   }
   

}

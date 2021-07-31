package com.example.demo.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.StudentDAO;
import com.example.demo.model.Student;


@Repository
public class StudentDaoImpl implements StudentDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void createStudent(Student student) {
		
	   String CREATE_STUDENT_SQL = "INSERT INTO student(student_id,student_name,student_address) VALUES(?,?,?)";
	    int update = jdbcTemplate.update(CREATE_STUDENT_SQL, student.getStudentId(),student.getStudentName(),student.getStudentAddress());
	   
	   if(update == 1) {
		   System.out.println("Student Created");
	   }
	

	}

	@Override
	public Student getStudentById(Integer studentId) {
    String GET_STUDENT_SQL = "Select * FROM student WHERE student_id=?";
	Student student = jdbcTemplate.queryForObject(GET_STUDENT_SQL, new StudentRowMapper(), studentId);
		return student;
	}

	@Override
	public void deleteStudentById(Integer studentId) {
		String DEL_STUDENT_SQL = "Delete from student where student_id=?";
		int update = jdbcTemplate.update(DEL_STUDENT_SQL, studentId);
		if(update ==1) {
			System.out.println("Student is deleted");
			
		}
	
	}

}

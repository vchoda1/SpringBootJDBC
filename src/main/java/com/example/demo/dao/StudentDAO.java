package com.example.demo.dao;

import com.example.demo.model.Student;

public interface StudentDAO {
	
	public abstract void createStudent(Student student);
	public abstract Student getStudentById(Integer studentId);
	public abstract void deleteStudentById(Integer studentId);

}

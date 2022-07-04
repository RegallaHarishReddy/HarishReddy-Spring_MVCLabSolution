package com.studentmanagement.service;
import java.util.List;

import com.studentmanagement.entity.Student;


public interface IStudentService {

	public List<Student> findAll();

	public Student findById(int id);

	public void save(Student student);

	public void deleteById(int id);
}

package com.studentmanagement.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.studentmanagement.entity.Student;

@Repository
public class StudentServiceImpl implements IStudentService{
	
	private SessionFactory factory;
	private Session session;

	@Autowired // automatically inject the SessionFactory dependency
	public StudentServiceImpl(SessionFactory factory) {
		this.factory = factory;
		setSession();
	}

	private void setSession() {
		try {
			session = factory.getCurrentSession();
		} catch (Exception ex) {
			session = factory.openSession();
		}
	}


	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		session.beginTransaction();
		List<Student> students = session.createQuery("from Student").getResultList();
		session.getTransaction().commit();
		return students;
		
		//return null;
	}

	@Override
	public Student findById(int id) {
		// TODO Auto-generated method stub
		session.beginTransaction();
		Student student = session.get(Student.class, id);
		session.getTransaction().commit();
		return student;
		//return null;
	}

	@Override
	public void save(Student student) {
		// TODO Auto-generated method stub
		session.beginTransaction();
		session.save(student);
		session.getTransaction().commit();
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		session.beginTransaction();
		Student student = session.get(Student.class, id);
		session.delete(student);
		session.getTransaction().commit();
	}

}

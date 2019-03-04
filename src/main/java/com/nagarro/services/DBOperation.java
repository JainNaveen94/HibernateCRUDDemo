package com.nagarro.services;

import org.hibernate.Session;

import com.nagarro.controller.UserInput;
import com.nagarro.dao.DataBase;
import com.nagarro.entity.Student;

public class DBOperation {
	
	public static Session session = DataBase.getSessionFactory().openSession();
	
	public static int insertRecordIntoDB(Student student) {
		int inserted = 0;
		if(student != null) {
			session.beginTransaction();
			inserted = (int) session.save(student);
			session.getTransaction().commit();
			inserted =  1;
		}
		return inserted;
	}
	
	public static int deleteRecordFromDB(int id) {
		int deleted = 0;
		Student student = getRecordFromDB(id);
		if(student != null) {
			session.beginTransaction();
			session.delete(student);
			session.getTransaction().commit();
			deleted = 1;
		}
		return deleted;
	}
	
	public static int updateRecordIntoDB(int id) {
		int updated = 0;
		Student student = getRecordFromDB(id);
		if(student != null) {
			session.beginTransaction();
			student.setName(UserInput.getStudentName());
			student.setAge(UserInput.getStudentAge());
			student.setEmail(UserInput.getStudentEmail());
			student.setClassName(UserInput.getStudentClass());
			session.update(student);
			session.getTransaction().commit();
			updated = 1;
		}
		return updated;
	}
	
	public static Student getRecordFromDB(int id) {
		Student student = new Student() ;
		session.beginTransaction();
		student =  session.get(Student.class, id);
		session.getTransaction().commit();
		return student;
	}
	
	public void closeSession() {
		session.close();
	}

}

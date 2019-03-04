package com.nagarro.dto;

import com.nagarro.entity.Student;
import com.nagarro.services.DBOperation;

public class DBOperationTransfer {

	public static int insertionOfRecordIntoDB(Student student) {
		int inserted = DBOperation.insertRecordIntoDB(student);
		return inserted;
	}
	
	public static int deletionOfRecordFromDB(int id) {
		int updated = DBOperation.updateRecordIntoDB(id);
		return updated;
	}
	
	public static int UpdationOfRecordIntoDB(int id) {
		int updated = DBOperation.updateRecordIntoDB(id);
		return updated;
	}
	
	public static Student getStudentFromDB(int id) {
		Student student = DBOperation.getRecordFromDB(id);
		return student;
	}
}

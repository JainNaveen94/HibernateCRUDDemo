package com.nagarro.controller;

import java.util.Date;
import java.util.Scanner;

import com.nagarro.entity.Student;

public class UserInput {
	
	public static Scanner scanner = new Scanner(System.in);
	
	/*public static int getUserInput() {
		int entry;
		System.out.println("Enter The Number of Record You Want TO Enter ");
		//try(Scanner scanner = new Scanner(System.in)) {
			entry = scanner.nextInt();
		//}
		
		return entry;
		for(int i=0; i<entry; i++) {
			getStudentInput(i);
		}
	}
	
	
	public static Student getStudentInput(int index) {
		Student student = new Student();
		//try(Scanner scanner = new Scanner(System.in)){
			System.out.println("Enter The Student Name " + index+1);
			String name = scanner.next();
			student.setName(name);
			System.out.println("Enter The Student Age " + index+1);
			student.setAge(scanner.nextInt());
			System.out.println("Enter The Student Email " + index+1);
			student.setEmail(scanner.next());
			System.out.println("Enter The Student Class " + index+1);
			student.setClassName(scanner.next());
			student.setRegistrationDate(new Date());
		//}
		return student;
	}*/
	
	public static Student getStudentInput() {
		Student student = new Student();
		student.setName(getStudentName());
		student.setAge(getStudentAge());
		student.setEmail(getStudentEmail());
		student.setClassName(getStudentClass());
		student.setRegistrationDate(new Date());
		return student;
	}
	
	public static String getStudentName() {
		System.out.print("\nEnter The Student Name :: ");
		String studentName = scanner.next();
		return studentName;
	}
	
	public static int getStudentAge() {
		System.out.print("\nEnter The Student Age :: ");
		int studentAge = scanner.nextInt();
		return studentAge;
	}
	
	public static String getStudentEmail() {
		System.out.print("\nEnter The Student Email :: ");
		String studentEmail = scanner.next();
		return studentEmail;
	}
	
	public static String getStudentClass() {
		System.out.print("\nEnter The Student Class ::");
		String studentClassName = scanner.next();
		return studentClassName;
	}
	
	public static int getStudentId() {
		int studentId;
		System.out.print("\nEnter The Student Id :: ");
		studentId = scanner.nextInt();
		return studentId;
	}
	
	
}

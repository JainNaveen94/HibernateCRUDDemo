package com.nagarro.controller;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.nagarro.constants.CRUDConstants;
import com.nagarro.entity.Student;
import com.nagarro.userexceptions.AgeGreaterThan3Exception;
import com.nagarro.userexceptions.AgeLessThan30Exception;
import com.nagarro.userexceptions.CannotBeAIntegerException;

public class UserInput {
	
	public static Scanner scanner = new Scanner(System.in);
	
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
		boolean pass = true;
		String studentName = "";
		do {
			try {
				System.out.print(CRUDConstants.STUDENT_NAME);
				studentName = scanner.next();
				try {
					@SuppressWarnings("unused")
					int check = Integer.parseInt(studentName);
					throw new CannotBeAIntegerException();	
				} catch(NumberFormatException exception) {
					pass = false;
				}
			} catch(CannotBeAIntegerException exception) {
				System.out.print("\n Student Name Cannot Be Integer ");
			}
		}while(pass == true);
		return studentName;
	}
	
	public static int getStudentAge() {
		boolean pass = true;
		int studentAge = 0;
		do {
			try {
				System.out.print(CRUDConstants.STUDENT_AGE);
				studentAge = scanner.nextInt();
				if(studentAge < 3) {
					throw new AgeGreaterThan3Exception();
				} else if(studentAge > 30) {
					throw new AgeLessThan30Exception();
				} else {
					pass = false;
				}
			} catch(InputMismatchException exception) {
				System.out.print("\n Student Age Cannot be a String Value");
				scanner.next();
			} catch(AgeGreaterThan3Exception exception) {
				System.out.print("\n Student Age Should Greater Than Or Equal To 3 Years");
			} catch(AgeLessThan30Exception exception) {
				System.out.print("\n Student Age Should Less Than Or Equal To 30 Years");
			}
		}while(pass == true);
		return studentAge;
	}
	
	public static String getStudentEmail() {
		boolean pass = true;
		String studentEmail = "";
		do {
			System.out.print(CRUDConstants.STUDENT_EMAIL);
			studentEmail = scanner.next();
			Pattern pattern = Pattern.compile(CRUDConstants.EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(studentEmail);
			boolean validemail= matcher.matches();
			if(validemail) {
				pass = false;
			} else {
				System.out.print("\n Enter the Valid Email Address(Ex:-hello@domain.com)");
			}
		}while(pass == true);
		return studentEmail;
	}
	
	public static String getStudentClass() {
		boolean pass = true;
		String studentClassName = "";
		do {
			try {
				System.out.print(CRUDConstants.STUDENT_CLASS_NAME);
				studentClassName = scanner.next();
				try {
					@SuppressWarnings("unused")
					int check = Integer.parseInt(studentClassName);
					throw new CannotBeAIntegerException();
				} catch(NumberFormatException exception) {
					pass = false;
				}
			} catch(CannotBeAIntegerException exception) {
				System.out.print("\n Student Class Cannot Be Integer ");
			}
		}while(pass == true);
		return studentClassName;
	}
	
	public static int getStudentId() {
		boolean pass = true;
		int studentId = 0;
		do {
			try {
				System.out.print(CRUDConstants.STUDENT_ID);
				studentId = scanner.nextInt();
				pass = false;
			} catch (InputMismatchException exception) {
				System.out.print("\n Student ID Cannot be a String Value");
				scanner.next();
			}
		}while(pass == true);
		return studentId;
	}
	
	public static int getValidOptionchoice() {
		int option = 0;
		boolean check = true;
		do {
			try {
				System.out.print(CRUDConstants.MENU_OPTION_NUMBER);
				option = scanner.nextInt();
				check = false;
			} catch(InputMismatchException e) {
				System.out.println("option should be Number");
				scanner.next();
			}
		}while(check == true);
		return option;
	}
	
	
}

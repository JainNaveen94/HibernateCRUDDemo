package com.nagarro.controller;

import java.util.Scanner;

import com.nagarro.dto.DBOperationTransfer;
import com.nagarro.entity.Student;

public class DataEntryMenu {

	public static Scanner sc = new Scanner(System.in);
	
	public static void getDataEntryMenu() {
		String menuchoice = "yes";
		
		do {
			int optionchoice;
			System.out.println("*****(@_@)::DATA ENTRY MENU::(@_@)*****");
			System.out.println("1. For Insert The Data" + 
								"\n2. For Delete The Data" +
								"\n3. For Update The Data" +
								"\n4. For Search The Data" +
								"\n5. For Exit To The Menu");
			System.out.print("\nEnter your Choice :: ");
			optionchoice = sc.nextInt();
			switch(optionchoice){
				case 1:
					Student student = UserInput.getStudentInput();
					int inserted = DBOperationTransfer.insertionOfRecordIntoDB(student);
					if(inserted == 1) {
						System.out.println("Inserted Sucessfully");
					} else {
						System.out.println("Insertion Failed");
					}
					break;
				
				case 2:
					int id1 = UserInput.getStudentId();
					int deleted = DBOperationTransfer.deletionOfRecordFromDB(id1);
					if(deleted == 1) {
						System.out.println("Record Deleted Sucessfully");
					} else {
						System.out.println("Deletion Of Record Fails");
					}
					break;
				
				case 3:
					int id2 = UserInput.getStudentId();
					int updated = DBOperationTransfer.UpdationOfRecordIntoDB(id2);
					if(updated == 1) {
						System.out.println("Updation Sucessfully");
					} else {
						System.out.println("Updation Failed");
					}
					break;
				
				case 4:
					int id3 = UserInput.getStudentId();
					student = DBOperationTransfer.getStudentFromDB(id3);
					if(student == null) {
						System.out.println("there is No Such Student Exist");
					} else {
						System.out.print("\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
						System.out.print("\n~~~~~~(#_#)::Student Details::(#_#)~~~~~~");
						System.out.print("\nStudent ID       ::" + student.getId());
						System.out.print("\nStudent Name     ::" + student.getName());
						System.out.print("\nStudent Class    ::" + student.getClassName());
						System.out.print("\nStudent Age      ::" + student.getAge());
						System.out.print("\nStudent Email    ::" + student.getEmail());
						System.out.print("\nRegistration Date::" + student.getRegistrationDate());
						System.out.print("\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
					}
					break;
					
				case 5:
					System.exit(0);
					break;
					
				default:
					System.out.println("You Enter The Wrong Option");
					System.out.println("!!Please try Again!!");
					break;
					
			}
			System.out.print("\n\nDo you Want to Continue :: ");
			menuchoice = sc.next();
		}while(menuchoice.equalsIgnoreCase("yes")
					|| menuchoice.equalsIgnoreCase("y"));
	}
}

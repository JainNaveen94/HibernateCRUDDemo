

package com.nagarro.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name ="Student_Table")
@DynamicUpdate
public class Student {
	
	// Field Of The Student Entity Class.
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Stud_id")
	private Integer id;
	
	@Column(name = "Stud_name", nullable = false, length = 100)
	private String name;
	
	@Column(name = "Stud_age", nullable = false, length = 3)
	private Integer age;
	
	@Column(name = "Stud_class", nullable = false, length = 50)
	private String className;
	
	@Column(name = "Stud_registation_date", nullable = false)
	private Date registrationDate;
	
	@Column(name = "Stud_email", unique = true)
	private String email;
	
	// Default Constructor
	
	public Student() {
		
	}

	// Getter/ Setter For The Student Entity Class
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}

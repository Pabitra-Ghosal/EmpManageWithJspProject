package com.example.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empid;
	
	@Column(length = 30)
	private String name;
	
	@Column(length = 30, unique = true)
	private String email;
	
	@Column(length = 30)
	private String pass;
	
	@Column(length = 10)
	private String role;
	
	@OneToOne
	@JoinColumn(name = "departmentId")
	private Department department;
	
	private Date dob;
	private Date joinDate;
}

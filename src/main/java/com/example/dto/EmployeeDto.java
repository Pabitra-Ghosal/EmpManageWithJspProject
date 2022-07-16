package com.example.dto;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeDto {
	
	private int empid;
	

	private String name;
	

	private String email;
	

	private String pass;
	

	private String role;
	

	private String depName;
	

	private Date dob;
	

	private Date joinDate;
	
	public EmployeeDto(String name, String email, String pass, String role, String depName, Date dob,
			Date joinDate) {
		super();
		this.name = name;
		this.email = email;
		this.pass = pass;
		this.role = role;
		this.depName = depName;
		this.dob = dob;
		this.joinDate = joinDate;
	}
	
	

}

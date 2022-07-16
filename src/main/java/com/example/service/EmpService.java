package com.example.service;

import java.util.List;

import com.example.dto.EmployeeDto;

public interface EmpService {
	
	public String createEmployee(EmployeeDto dto);
	public String updateEmployee(EmployeeDto dto,int empid);
	public String deleteEmployee(int empid);
	public List<EmployeeDto> getAllEmployee();
	public EmployeeDto getEmployee(int empid);
	public boolean validEmployee(String email,String pass);
	public EmployeeDto getEmployee(String email);
}

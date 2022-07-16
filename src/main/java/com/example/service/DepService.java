package com.example.service;

import com.example.dto.DepartmentDto;


public interface DepService {
	
	public boolean createDepartment(DepartmentDto dto);
	public boolean updateDepartment(DepartmentDto dto,int depid);
	public boolean deleteDepartment(int depid);
}

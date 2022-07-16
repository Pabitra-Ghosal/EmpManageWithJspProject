package com.example.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.EmployeeDto;
import com.example.entity.Employee;
import com.example.repository.EmpRepository;
import com.example.service.EmpService;

@Service
public class EmpServiceImpl implements EmpService{

	@Autowired
	EmpRepository empRepo;
	
	@Autowired
	ModelMapper mapper;
	
	@Override
	public String createEmployee(EmployeeDto dto) {
		Employee employee=mapper.map(dto, Employee.class);
		Employee exists=this.empRepo.findByEmail(employee.getEmail());
		if(exists!=null)
			return "employee exsisted";
		employee = this.empRepo.save(employee);
		if(employee.getEmpid()>0)
			return "Registration success your employee Id is "+employee.getEmpid();
		return "not created";
	}

	@Override
	public String updateEmployee(EmployeeDto dto, int empid) {
		Employee exixts=this.empRepo.findById(empid).get();
		if(exixts==null)
			return "invalid empid";
		Employee employee=this.mapper.map(dto, Employee.class);
		employee.setEmpid(empid);
		employee =this.empRepo.save(employee);
		if(employee.getEmpid()==empid)
		return "emp updated";
		return "not updated";
	}

	@Override
	public String deleteEmployee(int empid) {
		Employee employee=this.empRepo.findById(empid).get();
		if(employee!=null)
		{
			this.empRepo.delete(employee);
			return "emp deleted";
		}
		return "empid invalid";	
	}

	@Override
	public List<EmployeeDto> getAllEmployee() {
		List<Employee> list= this.empRepo.findAll();
		List<EmployeeDto> dtoList=new ArrayList<EmployeeDto>();
		for(Employee emp : list)
		{
			EmployeeDto dto=this.mapper.map(emp, EmployeeDto.class);
			dtoList.add(dto);
		}
		return dtoList;
	}

	@Override
	public EmployeeDto getEmployee(int empid) {
		Employee employee=this.empRepo.findById(empid).get();
		EmployeeDto dto=this.mapper.map(employee, EmployeeDto.class);
		return dto;
	}
	
	@Override
	public EmployeeDto getEmployee(String email) {
		Employee employee=this.empRepo.findByEmail(email);
		EmployeeDto dto=this.mapper.map(employee, EmployeeDto.class);
		return dto;
	}

	@Override
	public boolean validEmployee(String email, String pass) {
		Employee employee=this.empRepo.findByEmailAndPass(email, pass);
		if(employee!=null)
		return true;
		return false;
	}
	
	

}

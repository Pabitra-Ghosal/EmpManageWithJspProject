package com.example.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.DepartmentDto;
import com.example.entity.Department;
import com.example.repository.DepRepository;
import com.example.service.DepService;

@Service
public class DepServiceImpl implements DepService {

	@Autowired
	DepRepository depRepo;
	
	@Autowired
	ModelMapper mapper;
	
	@Override
	public boolean createDepartment(DepartmentDto dto) {
		
		Department department=mapper.map(dto, Department.class);
		Department exsisted=this.depRepo.findByDepName(department.getDepName());
		if(exsisted!=null)
			return false;
		department=this.depRepo.save(department);
		if(department!=null)
			return true;
		return false;
	}

	@Override
	public boolean updateDepartment(DepartmentDto dto, int depid) {
		Department exsisted=this.depRepo.findById(depid).get();
		if(exsisted.getDepartmentId()!=depid)
			return false;
		Department updatedDep=mapper.map(dto, Department.class);
		updatedDep.setDepartmentId(depid);
		updatedDep=this.depRepo.save(updatedDep);
		if(updatedDep!=null)
			return true;
		return false;
	}

	@Override
	public boolean deleteDepartment(int depid) {
		Department department=this.depRepo.findById(depid).get();
		if(department!=null)
		{
			this.depRepo.deleteById(depid);
			return true;
		}
		return false;
	}
	
	

}

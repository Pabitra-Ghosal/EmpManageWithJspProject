package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Employee;

@Repository
public interface EmpRepository extends JpaRepository<Employee, Integer>{

	public Employee findByEmail(String email);
	public Employee findByEmailAndPass(String email,String pass);
}

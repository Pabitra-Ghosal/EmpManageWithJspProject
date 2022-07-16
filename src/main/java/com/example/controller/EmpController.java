package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.dto.EmployeeDto;
import com.example.service.EmpService;

@Controller
@RequestMapping("/emp")
public class EmpController {
	
	@Autowired
	EmpService empService;
	
	@RequestMapping("/ind")
	public String indexPage()
	{
		return "hellopage";
	}
	
	@RequestMapping("/reg")
	public String regPage()
	{
		return "Register";
	}
	
	@RequestMapping(path = "/register",method = RequestMethod.POST)
	public String createEmployee(@ModelAttribute EmployeeDto dto,Model model)
	{
		System.out.println(dto);
		String msg=this.empService.createEmployee(dto);
		if(msg.equals("employee exsisted"))
		{
			model.addAttribute("msg", "Employee already exsist please login");
			return "hellopage";	
		}
		else if(msg.equals("not created"))
		{
			model.addAttribute("msg", "Registration failed please try again");
			return "Register";
		}
		else
		{
			model.addAttribute("msg", msg);
			return "hellopage";	
		}
			
	}
	
	@RequestMapping(path = "/login",method = RequestMethod.POST)
	public String login(@ModelAttribute EmployeeDto dto,HttpSession session,Model model)
	{
		System.out.println(dto);
		boolean check=this.empService.validEmployee(dto.getEmail(), dto.getPass());
		if(check)
		{
			EmployeeDto exsistedDto=this.empService.getEmployee(dto.getEmail());
			session.setAttribute("userName", exsistedDto.getName());
			session.setAttribute("empid", exsistedDto.getEmpid());
			return "profile";
		}
		else
		{
			model.addAttribute("msg", "Invalid Email or Password");
			return "hellopage";	
		}
		
	}
	
	@RequestMapping("/update")
	public String update( Model model,HttpSession session)
	{
		EmployeeDto dto=this.empService.getEmployee((Integer)session.getAttribute("empid"));
		model.addAttribute("empDto", dto);
		System.out.println(dto);
		return "Update";
		
	}
	
	@RequestMapping("/edit")
	public String updateEmp(@ModelAttribute EmployeeDto dto,HttpSession session,Model model)
	{
		String msg=this.empService.updateEmployee(dto, (Integer)session.getAttribute("empid"));
		if(msg.equals("invalid empid"))
		{
			model.addAttribute("msg", "Employee not found");
			return "hellopage";	
		}
		else if(msg.equals("not updated"))
		{
			model.addAttribute("msg", "Update failed please try again");
			return "profile";
		}
		else
		{
			model.addAttribute("msg", "Update Successful..");
			return "profile";
		}
	}
	
}

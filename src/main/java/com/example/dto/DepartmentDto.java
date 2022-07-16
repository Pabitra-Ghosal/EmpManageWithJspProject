package com.example.dto;

import java.sql.Date;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DepartmentDto {
	
	@NotNull(message = "Department name can't be blank")
	private String depName;
	
	@NotNull(message = "Department role can't be blank")
	private String depRole;
	
	@NotNull(message = "Department creation date can't be blank")
	private Date createDate;
	
	public DepartmentDto(String depName, String depRole, Date createDate) {
		super();
		this.depName = depName;
		this.depRole = depRole;
		this.createDate = createDate;
	}
	
	
}

package com.github.dtos;

import java.util.List;

public class EmpDto {
	private Integer id;
	private String name;
	private Integer age;
	private Integer salary;
	private String address;
	
	private  List<EmpDto> empList;

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

	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public List<EmpDto> getEmpList() {
		return empList;
	}
	public void setEmpList(List<EmpDto> empList) {
		this.empList = empList;
	}
}
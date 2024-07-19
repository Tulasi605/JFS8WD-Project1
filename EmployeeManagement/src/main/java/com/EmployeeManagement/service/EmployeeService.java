package com.EmployeeManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EmployeeManagement.Model.EmployeeModel;
import com.EmployeeManagement.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRep;
	//-----------------------Add employee methods---------------------

	public EmployeeModel saveEmployee(EmployeeModel employee) {
		return employeeRep.save(employee);
	}
	
	//-----------------------Employee List methods--------------------
	public List<EmployeeModel> getAllEmployees(){
		return employeeRep.findAll();
	}
	
	//-----------------------Employee Search methods-------------------
	
	public Optional<EmployeeModel> getEmployeeId(String id){
		return employeeRep.findById(id);
	}
	//-------------------------Editing methods-------------------------
	
	public List<EmployeeModel> editEmployee(){
		return employeeRep.findAll();
	}
	
	//-------------------------delete methods-------------------------
	public void deleteEmployeeById(String id) {
		this.employeeRep.deleteById(id);
		
	}

	//--------------Counting methods--------------------
	 public String getMaleCount() {
	        return employeeRep.countByGender("Male");
	    }

	 public String getFemaleCount() {
	        return employeeRep.countByGender("Female");
	    }
	 public String getOtherCount() {
	        return employeeRep.countByGender("Other");
	    }
	 public long getTotalCount() {
	        return employeeRep.count();
	    }
}

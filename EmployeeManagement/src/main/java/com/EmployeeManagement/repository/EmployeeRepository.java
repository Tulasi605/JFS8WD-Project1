package com.EmployeeManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.EmployeeManagement.Model.*;

	@Repository
		
	public interface EmployeeRepository extends JpaRepository<EmployeeModel, String> {
		String countByGender(String gender);
	}
package com.bazaarvoice.stoplight.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bazaarvoice.stoplight.dao.EmployeeDao;
import com.bazaarvoice.stoplight.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired 
	EmployeeRepository employeeRepository;
	
	public Iterable<EmployeeDao> getEmployees() {
		return employeeRepository.findAll();
	}
	
	public Optional<EmployeeDao> getEmployeesById(Long id) {
		return employeeRepository.findById(id);
	}
	
	public void deleteEmployeesById(Long id) {
		employeeRepository.deleteById(id);
	}
	
	public long getEmployeesHeadCount() {
		return employeeRepository.count();
	}

	public ArrayList<String> getEmployeeTitles() {
		// TODO Auto-generated method stub
		return employeeRepository.getUniqueTitles();
	}

	public List<Object[]> getEmployeesHeadCountByTitle() {
		// TODO Auto-generated method stub
		return employeeRepository.getCountByTitle();
	}
}

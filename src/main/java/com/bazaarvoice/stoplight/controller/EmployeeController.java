package com.bazaarvoice.stoplight.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bazaarvoice.stoplight.dao.EmployeeDao;
import com.bazaarvoice.stoplight.service.EmployeeService;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@OpenAPIDefinition(info = @Info(title = "Bash Insider API", description = "The API allows user to perform Employee information related transactions such as retrieve and delete employee records."))
@Tag(name = "Employee API")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@Operation(summary = "Get Employees List", description = "The API returns list of all the employee records stored in Bash Insider system")
	@GetMapping("/employees")
	Iterable<EmployeeDao> getEmployees() {
		return employeeService.getEmployees();
	}

	@Operation(summary = "Get Employee By Identifier", description = "The API returns the specific employee record based on identifier, stored in Bash Insider system")
	@GetMapping("/employees/{id}")
	Optional<EmployeeDao> getEmployeesById(@PathVariable("id") Long id) {
		return employeeService.getEmployeesById(id);
	}

	@Operation(summary = "Get Employee Headcount", description = "Returns the total count of employees")
	@GetMapping("/employees/count")
	long getEmployeesHeadCount() {
		return employeeService.getEmployeesHeadCount();
	}

	@Operation(summary = "List Employee Titles", description = "Returns the unique employee titles")
	@GetMapping("/employees/titles")
	ArrayList<String> getUniqueTitles() {
		return employeeService.getEmployeeTitles();
	}


	@Operation(summary = "Get Employee Headcount by Job Title", description = "Returns the total count of employees for specific")
	@GetMapping("/employees/titles/count")
	List<Object[]> getEmployeesHeadCountByTitle() {
		return employeeService.getEmployeesHeadCountByTitle();
	}

	@Operation(summary = "Remove an employee by Identifier", description = "The API allows to delete the specific employee record based on identifier, stored in Bash Insider system")
	@DeleteMapping("/employees/{id}")
	void deleteEmployees(@PathVariable("id") Long id) {
		employeeService.deleteEmployeesById(id);
	}

}

package com.avinty.hr;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class APIController {
	private final EmployeeRepository eRepository;
	private final DepartmentRepository dRepository;
	
	APIController(EmployeeRepository eRepository, DepartmentRepository dRepository) {
		this.eRepository=eRepository;
		this.dRepository=dRepository;
	}
	
	@GetMapping("/API/V1/employees")
	List<Employee> getEmployees() {
		return eRepository.findAll();
	}
	
	@GetMapping("/API/V1/dep-emp")
	List<Employee> getEmpByDep() {
		return eRepository.getEmployeesByDepartment();
	}
	
	@GetMapping("/API/V1/department?name=?")
	List<Department> filterDepartment(String name) {
		return dRepository.filterByName(name);
	}
	
	@PostMapping("/API/V1/employees")
	Employee newEmployee(@RequestBody Employee newEmployee) {
		return eRepository.save(newEmployee);
	}
	
	@DeleteMapping("/API/V1/department/:{id}")
	void deleteDepartment(@PathVariable int id) {
		dRepository.deleteById(id);
		eRepository.setDepIdToNull(id);
	}

}

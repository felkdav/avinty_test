package com.avinty.hr;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

interface DepartmentRepository extends JpaRepository<Department, Integer> {
	@Query(value="select depName from departments where depName=\"{name}\"")
	List<Department> filterByName(@PathVariable String name);
}
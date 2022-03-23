package com.avinty.hr;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	@Query(value="select id from employees group by depId")
	List<Employee> getEmployeesByDepartment();
	
	@Modifying(flushAutomatically = true)
	@Query(value="update employees set depId = NULL where depId = id")
	void setDepIdToNull(@Param("id") int id);
}

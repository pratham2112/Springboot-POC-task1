package com.demo.springjpa.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.springjpa.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	@Query(" from Employee where firstName like '%?1%' ")
	public List<Employee> findBySearch(String search);
	
	@Modifying
	@Transactional
	@Query(" update Employee set deleted = 1 where deleted = 0 and id = ?1 ")
	public void setDeleted(int id);

}

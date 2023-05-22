package com.example.restapiemployee.employee.dao;

import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeDao extends JpaRepository<EmployeeEntity, Long> {

}

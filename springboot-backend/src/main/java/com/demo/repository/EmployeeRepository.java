package com.demo.repository;

import org.springframework.stereotype.Repository;
import com.demo.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}

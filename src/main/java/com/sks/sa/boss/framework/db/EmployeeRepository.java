package com.sks.sa.boss.framework.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sks.sa.boss.dm.bean.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}

package com.xpx.dao;

import org.springframework.data.repository.CrudRepository;

import com.xpx.entity.Employee;

public interface EmployeeDao extends CrudRepository< Employee , Integer> {

}

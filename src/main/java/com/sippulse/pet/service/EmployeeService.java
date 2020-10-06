package com.sippulse.pet.service;

import com.sippulse.pet.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public abstract Employee addEmployee(Employee employee);
    public abstract List<Employee> listEmployee();
    public abstract Employee showEmployee(Long id);
    public abstract Employee showEmployee(String email);
    public abstract Employee updateEmployee(Employee employee);
    public abstract void deteleEmployeeById(Long id);
}

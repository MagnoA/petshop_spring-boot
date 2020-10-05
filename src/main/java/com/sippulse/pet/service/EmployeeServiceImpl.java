package com.sippulse.pet.service;

import com.sippulse.pet.entity.Employee;
import com.sippulse.pet.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee addEmployee(Employee employee) {
        return null;
    }

    @Override
    public List<Employee> listEmployee() {
        return null;
    }

    @Override
    public Employee showEmployee(Long id) {
        return null;
    }

    @Override
    public Employee showEmployee(String email) {
        return null;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return null;
    }

    @Override
    public void deteleEmployeeById(Long id) {

    }

    @Override
    public void deleteEmployeeByEmail(String email) {

    }
}

package com.sippulse.pet.service;

import com.sippulse.pet.entity.Client;
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
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> listEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee showEmployee(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Employee showEmployee(String email) {
        return employeeRepository.findByEmail(email);
    }

    @Override
    public Employee updateEmployeeById(Employee employee) {

        Employee employeeToUpdate = employeeRepository.findById(employee.getId());

        if(!employeeToUpdate.getEmail().equals(employee.getEmail()))
            employeeToUpdate.setEmail(employee.getEmail());

        if(!employeeToUpdate.getName().equals(employee.getName()))
            employeeToUpdate.setName(employee.getName());

        if(!employeeToUpdate.getRole().equals(employee.getRole()))
            employeeToUpdate.setRole(employee.getRole());

        if(!employeeToUpdate.getPassword().equals(employee.getPassword()))
            employeeToUpdate.setPassword(employee.getPassword());

        return employeeToUpdate;
    }

    @Override
    public void deteleEmployeeById(Long id) {
        employeeRepository.delete(id);
    }
}

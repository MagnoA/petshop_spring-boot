package com.sippulse.pet.controller;

import com.sippulse.pet.entity.Client;
import com.sippulse.pet.entity.Employee;
import com.sippulse.pet.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> listEmployees(){
        return new ResponseEntity<>(employeeService.listEmployee(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable(value = "id") Long id){
        return new ResponseEntity<>(employeeService.showEmployee(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/email")
    public ResponseEntity<?> getEmployeeByEmail(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.showEmployee(employee.getEmail()), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> registerEmployee(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.addEmployee(employee), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> updateEmployeeById(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.updateEmployee(employee),HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<?> deleteEmployeeById(@PathVariable(value = "id") Long id){
        employeeService.deteleEmployeeById(id);
        return new ResponseEntity<>(employeeService.listEmployee(), HttpStatus.OK);
    }
}

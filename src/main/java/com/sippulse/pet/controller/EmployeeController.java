package com.sippulse.pet.controller;

import com.sippulse.pet.entity.Employee;
import com.sippulse.pet.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Classe controller que permite o gerenciamento de funcionarios
 */
@RestController
@RequestMapping(value = "employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * Metodo que realiza a busca de todos os funcionarios
     * @return ResponseEntity HTTP 200 - JSON com as informacoes de todos os funcionarios
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> listEmployees(){
        return new ResponseEntity<>(employeeService.listEmployee(), HttpStatus.OK);
    }

    /**
     * Metetodo que busca funcionario por ID
     * @param id
     * @return ResponseEntity HTTP 200 - JSON com as informacoes do usuario
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable(value = "id") Long id){
        return new ResponseEntity<>(employeeService.showEmployee(id), HttpStatus.OK);
    }

    /**
     * Metodo que busca funcionario por e-mail
     * @param employee
     * @return ResponseEntity HTTP 200 - JSON com as informacoes do funcionario
     */
    @RequestMapping(method = RequestMethod.GET, value = "/email")
    public ResponseEntity<?> getEmployeeByEmail(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.showEmployee(employee.getEmail()), HttpStatus.OK);
    }

    /**
     * Metodo para registro de funcionario
     * @param employee
     * @return ResponseEntity HTTP 200 - JSON com as informacoes do novo funcionario
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> registerEmployee(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.addEmployee(employee), HttpStatus.OK);
    }

    /**
     * Metodo que atualiza as informacoes do funcionario
     * @param employee
     * @return ResponseEntity HTTP 200 - JSON com as informacoes atualizadas
     */
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> updateEmployeeById(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.updateEmployee(employee),HttpStatus.OK);
    }

    /**
     * Metodo que remove um funcionario dos registros pelo ID
     * @param id
     * @return ResponseEntity HTTP 200 - JSON com todos os demais funcionarios
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<?> deleteEmployeeById(@PathVariable(value = "id") Long id){
        employeeService.deteleEmployeeById(id);
        return new ResponseEntity<>(employeeService.listEmployee(), HttpStatus.OK);
    }
}

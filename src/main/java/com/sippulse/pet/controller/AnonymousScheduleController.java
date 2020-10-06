package com.sippulse.pet.controller;

import com.sippulse.pet.entity.Client;
import com.sippulse.pet.entity.Employee;
import com.sippulse.pet.entity.Schedule;
import com.sippulse.pet.service.EmployeeService;
import com.sippulse.pet.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Classe Controller que trata as requisicoes de consultas anonimas
 */
@RestController
public class AnonymousScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private EmployeeService employeeService;

    /**
     * Metodo que realiza buscas de consultas por data
     * @param schedule
     * @return ResponseEntity HTTP 200 - JSON com as informacoes das consultas agendadas
     */
    @RequestMapping(method = RequestMethod.GET, value = "/date")
    public ResponseEntity<?> listSchedules(@RequestBody Schedule schedule){
        return new ResponseEntity<>(scheduleService.listScheduleByDate(schedule), HttpStatus.OK);
    }

    /**
     * Metodo que realiza busca por cpf
     * @param client
     * @return ResponseEntity HTTP 200 - JSON com as informacoes das consultas dos clientes
     */
    @RequestMapping(method = RequestMethod.GET, value = "/client")
    public ResponseEntity<?> listSchedulesByVet(@RequestBody Client client) {
        return new ResponseEntity<>(scheduleService.listScheduleByClient(client), HttpStatus.OK);
    }

    /**
     * Metodo para PRIMEIRO registro de funcionario
     * @param employee
     * @return ResponseEntity HTTP 200 - JSON com as informacoes do novo funcionario
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> registerEmployee(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.addEmployee(employee), HttpStatus.OK);
    }

}

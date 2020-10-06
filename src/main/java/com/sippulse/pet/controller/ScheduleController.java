package com.sippulse.pet.controller;

import com.sippulse.pet.entity.Employee;
import com.sippulse.pet.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Classe controller que permite gerenciar a agenda
 */
@RestController
@RequestMapping(value = "/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    /**
     * Metodo que busta as informacoes de agenda de determinado funcionario
     * @param employee
     * @return ResponseEntity HTTP 200 - JSON com as informacoes da agenda
     */
    @RequestMapping(method = RequestMethod.GET, value = "/vet")
    public ResponseEntity<?> listSchedulesByVet(@RequestBody Employee employee) {
        return new ResponseEntity<>(scheduleService.listScheduleByEmployee(employee), HttpStatus.OK);
    }

    /**
     * Metodo que registra consulta(s)
     * @param employee
     * @return ResponseEntity HTTP 200 - JSON com as informacoes da consulta
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> registerSchedule(@RequestBody Employee employee){
        return new ResponseEntity<>(scheduleService.addSchedule(employee), HttpStatus.OK);
    }

    /**
     * Metodo que atualiza a agenda
     * @param employee
     * @return ResponseEntity HTTP 200 - JSON com as informacoes da consulta
     */
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> updateSchedule(@RequestBody Employee employee){
        return new ResponseEntity<>(scheduleService.updateSchedule(employee), HttpStatus.OK);
    }

    /**
     * Metodo que remove uma consulta pelo id
     * @param id
     * @return ResponseEntity HTTP 200
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<?> deleteScheduleByEmployee(@PathVariable(value = "id") Long id){
        scheduleService.deteleSchedule(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}

package com.sippulse.pet.controller;

import com.sippulse.pet.entity.Client;
import com.sippulse.pet.entity.Employee;
import com.sippulse.pet.entity.Schedule;
import com.sippulse.pet.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @RequestMapping(method = RequestMethod.GET, value = "/vet")
    public ResponseEntity<?> listSchedulesByVet(@RequestBody Employee employee) {
        return new ResponseEntity<>(scheduleService.listScheduleByEmployee(employee), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> registerSchedule(@RequestBody Employee employee){
        return new ResponseEntity<>(scheduleService.addSchedule(employee), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> updateSchedule(@RequestBody Employee employee){
        return new ResponseEntity<>(scheduleService.updateSchedule(employee), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<?> deleteScheduleByEmployee(@PathVariable(value = "id") Long id){
        return new ResponseEntity<>(scheduleService.deteleSchedule(id), HttpStatus.OK);
    }


}

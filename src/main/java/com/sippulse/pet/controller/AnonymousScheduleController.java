package com.sippulse.pet.controller;

import com.sippulse.pet.entity.Client;
import com.sippulse.pet.entity.Schedule;
import com.sippulse.pet.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnonymousScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @RequestMapping(method = RequestMethod.GET, value = "/date")
    public ResponseEntity<?> listSchedules(@RequestBody Schedule schedule){
        return new ResponseEntity<>(scheduleService.listScheduleByDate(schedule), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/client")
    public ResponseEntity<?> listSchedulesByVet(@RequestBody Client client) {
        return new ResponseEntity<>(scheduleService.listScheduleByClient(client), HttpStatus.OK);
    }

}

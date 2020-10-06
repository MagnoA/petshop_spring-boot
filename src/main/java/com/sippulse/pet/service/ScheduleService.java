package com.sippulse.pet.service;

import com.sippulse.pet.entity.Client;
import com.sippulse.pet.entity.Employee;
import com.sippulse.pet.entity.Pet;
import com.sippulse.pet.entity.Schedule;

import java.util.Date;
import java.util.List;

public interface ScheduleService {

    public abstract List<Schedule> addSchedule(Employee employee);
    public abstract List<Pet> listScheduleByDate(Schedule schedule);
    public abstract List<Pet> listScheduleByClient(Client client);
    public abstract List<Pet> listScheduleByEmployee(Employee employee);
    public abstract List<Pet> updateSchedule(Employee employee);
    public abstract void deteleSchedule(Long id);
}

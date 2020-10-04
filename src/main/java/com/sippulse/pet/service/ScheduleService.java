package com.sippulse.pet.service;

import com.sippulse.pet.entity.Schedule;

import java.util.List;

public interface ScheduleService {

    public abstract Schedule addSchedule(Schedule schedule);
    public abstract List<Schedule> listSchedules();
    public abstract Schedule showSchedule(Long id);
    public abstract Schedule showScheduleByClient(String cpf);
    public abstract Schedule showScheduleByEmployee(String email);
    public abstract Schedule updateSchedule(Schedule schedule);
    public abstract void deteleSchedule(Long id);
}

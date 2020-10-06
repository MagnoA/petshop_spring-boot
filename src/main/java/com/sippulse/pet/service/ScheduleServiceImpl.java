package com.sippulse.pet.service;

import com.sippulse.pet.entity.Client;
import com.sippulse.pet.entity.Employee;
import com.sippulse.pet.entity.Pet;
import com.sippulse.pet.entity.Schedule;
import com.sippulse.pet.repository.ClientRepository;
import com.sippulse.pet.repository.EmployeeRepository;
import com.sippulse.pet.repository.PetRepository;
import com.sippulse.pet.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService{

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Schedule> addSchedule(Employee employee) {
        Employee employeeSchedule = employeeRepository.findByEmail(employee.getEmail());
        Iterator<Schedule> scheduleIterator = employee.getSchedule().iterator();
        List<Schedule> scheduleList = new ArrayList<>();
        while (scheduleIterator.hasNext()) {
            Schedule schedule = scheduleIterator.next();
            Pet pet = petRepository.findById(schedule.getPet().getId());
            schedule.setEmployee(employeeSchedule);
            schedule.setPet(pet);
            scheduleRepository.save(schedule);
            scheduleList.add(schedule);
        }

        return scheduleList;
    }

    @Override
    public List<Schedule> listSchedule() {
        return scheduleRepository.findAll();
    }

    @Override
    public List<Schedule> listScheduleByIdPet(Long id) {
        return petRepository.findById(id).getSchedule();
    }

    @Override
    public List<Pet> listScheduleByDate(Schedule schedule) {
        Iterator<Schedule> scheduleIterator =  scheduleRepository.findByDate(schedule.getDate()).iterator();
        List<Pet> petList = new ArrayList<>();
        while (scheduleIterator.hasNext()){
            Schedule schedulePet = scheduleIterator.next();
            Pet pet = petRepository.findById(schedulePet.getPet().getId());
            petList.add(pet);
        }
        return petList;
    }

    @Override
    public List<Pet> listScheduleByClient(Client client) {
        if(clientRepository.findByCpf(client.getCpf()) == null)
            return null;
        List<Pet> pets = petRepository.findByClient(clientRepository.findByCpf(client.getCpf()));
        return pets;
    }

    @Override
    public List<Pet> listScheduleByEmployee(Employee employee) {
        System.out.println(employee.getEmail());
        Employee employeeSchedule = employeeRepository.findByEmail(employee.getEmail());
        if (employeeSchedule == null)
            return null;
        Iterator<Schedule> scheduleIterator = employeeSchedule.getSchedule().iterator();
        List<Pet> petList = new ArrayList<>();

        while (scheduleIterator.hasNext()){
            Schedule schedule = scheduleIterator.next();
            Pet pet = petRepository.findById(schedule.getPet().getId());
            petList.add(pet);
        }
        return petList;
    }

    @Override
    public List<Schedule> updateSchedule(Employee employee) {
        Iterator<Schedule> scheduleIterator = employee.getSchedule().iterator();
        List<Schedule> scheduleList = new ArrayList<>();
        while (scheduleIterator.hasNext()){
            Schedule schedule = scheduleIterator.next();
            Schedule scheduleToUpdate = scheduleRepository.findById(schedule.getId());

            if(scheduleToUpdate == null)
                return null;

            if(!scheduleToUpdate.getDate().equals(schedule.getDate()))
                scheduleToUpdate.setDate(schedule.getDate());

            if(!scheduleToUpdate.getPet().equals(schedule.getPet()))
                schedule.setPet(schedule.getPet());

            if(!scheduleToUpdate.getTime().equals(schedule.getTime()))
                scheduleToUpdate.setTime(schedule.getTime());

            scheduleRepository.save(scheduleToUpdate);
            scheduleList.add(scheduleToUpdate);
        }

        return scheduleList;
    }

    @Override
    public void deteleSchedule(Long id) {

    }
}

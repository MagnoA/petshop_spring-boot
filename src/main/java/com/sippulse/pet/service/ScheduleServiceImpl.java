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
import java.util.Iterator;
import java.util.List;

/** Classe que implementa os Servicos de agenda requisitados pelo controller
 * @author Allex Magno
 * @version 1.0
 */


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

    /**
     * Metodo que adiciona uma consulta na agenda do funcionario
     * @param employee
     * @return List<Schedule>
     */
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

    /**
     * Metodo que realiza busca das consultas por data
     * @param schedule
     * @return List<Pet> - Pets e inforacoes de agenda
     */
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

    /**
     * Metodo que realiza busca das consultas por cliente
     * @param client
     * @return List<Pet> - Pets e inforacoes de agenda
     */
    @Override
    public List<Pet> listScheduleByClient(Client client) {
        if(clientRepository.findByCpf(client.getCpf()) == null)
            return null;
        List<Pet> pets = petRepository.findByClient(clientRepository.findByCpf(client.getCpf()));
        return pets;
    }

    /**
     * Metodo que realiza busca das consultas por funcionario
     * @param employee
     * @return List<Pet> - Pets e inforacoes de agenda
     */
    @Override
    public List<Pet> listScheduleByEmployee(Employee employee) {
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

    /**
     * Metodo que atualiza as consultas de determinado funcionario
     * @param employee
     * @return List<Pet> - Pets e inforacoes de agenda
     */
    @Override
    public List<Pet> updateSchedule(Employee employee) {
        Iterator<Schedule> scheduleIterator = employee.getSchedule().iterator();
        List<Pet> petList = new ArrayList<>();
        while (scheduleIterator.hasNext()){
            Schedule schedule = scheduleIterator.next();
            Schedule scheduleToUpdate = scheduleRepository.findById(schedule.getId());

            if(scheduleToUpdate == null)
                return null;

            if(schedule.getDate() != null)
                scheduleToUpdate.setDate(schedule.getDate());

            if(schedule.getPet() != null)
                scheduleToUpdate.setPet(schedule.getPet());

            if(schedule.getTime() != null)
                scheduleToUpdate.setTime(schedule.getTime());

            scheduleRepository.save(scheduleToUpdate);
            petList.add(scheduleToUpdate.getPet());
        }

        return petList;
    }

    /**
     * Metodo que remove uma consulta pelo ID
     * @param id
     */
    @Override
    public void deteleSchedule(Long id) {
        scheduleRepository.delete(id);
    }
}

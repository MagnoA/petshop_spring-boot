package com.sippulse.pet.service;

import com.sippulse.pet.entity.Client;
import com.sippulse.pet.entity.Pet;
import com.sippulse.pet.entity.Schedule;
import com.sippulse.pet.repository.ClientRepository;
import com.sippulse.pet.repository.PetRepository;
import com.sippulse.pet.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class PetServiceImpl implements PetService{
// Implementação para os métodos da Interface.

    @Autowired
    private PetRepository petRepository;

    @Autowired
    ScheduleRepository scheduleRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Pet> addPet(Client client) {
        Client clientPet = clientRepository.findByCpf(client.getCpf());
        Iterator<Pet> petIterator = client.getPets().iterator();
        List<Pet> petList = new ArrayList<>();
        while (petIterator.hasNext()){
            Pet pet = petIterator.next();

            pet.setClient(clientPet);
            petList.add(pet);
            petRepository.save(pet);
        }
        return petList;
    }

    @Override
    public List<Pet> listPet() {
        return petRepository.findAll();
    }

    @Override
    public Pet showPet(Long id) {
        return petRepository.findById(id);
    }

    @Override
    public List<Pet> listPetByClient(String cpf) {
        return null;
    }

    @Override
    public List<Pet> listPetByEmployee(String email) {
        return null;
    }

    @Override
    public List<Pet> updatePet(Client client) {
        Iterator<Pet> petIterator = client.getPets().iterator();
        List<Pet> petList = new ArrayList<>();
        while (petIterator.hasNext()){
            Pet pet = petIterator.next();
            Pet petToUpdate = petRepository.findByIdAndClient_Id(
                    pet.getId(),
                    clientRepository.findByCpf(client.getCpf()).getId());

            if (pet.getName() != null)
                petToUpdate.setName(pet.getName());

            if (pet.getBreed() != null)
                petToUpdate.setBreed(pet.getBreed());

            if (pet.getKind() != null)
                petToUpdate.setKind(pet.getKind());

            petList.add(petToUpdate);
            petRepository.save(petToUpdate);
        }

        return petList;
    }

    @Override
    public Pet updatePet(Pet pet) {

        Pet petToUpdate = petRepository.findById(pet.getId());
        if (pet.getName() != null)
            petToUpdate.setName(pet.getName());

        if (pet.getBreed() != null)
            petToUpdate.setBreed(pet.getBreed());

        if (pet.getKind() != null)
            petToUpdate.setKind(pet.getKind());

        return petRepository.save(petToUpdate);
    }

    @Override
    public void detelePet(Client client) {
        Iterator<Pet> pets = client.getPets().iterator();
        while (pets.hasNext()) {
            Pet pet = pets.next();
            Iterator<Schedule> scheduleIterator = scheduleRepository.findByPet_Id(pet.getId()).iterator();
            while (scheduleIterator.hasNext()) {
                Schedule schedule = scheduleIterator.next();
                scheduleRepository.delete(schedule.getId());
            }
            petRepository.delete(pet.getId());
        }
    }
}

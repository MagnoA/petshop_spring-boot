package com.sippulse.pet.service;

import com.sippulse.pet.entity.Client;
import com.sippulse.pet.entity.Pet;
import com.sippulse.pet.entity.Schedule;
import com.sippulse.pet.repository.ClientRepository;
import com.sippulse.pet.repository.PetRepository;
import com.sippulse.pet.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/** Classe que implementa os Servicos Pet requisitados pelo controller
 * @author Allex Magno
 * @version 1.0
 */

@Service
public class PetServiceImpl implements PetService{
// Implementação para os métodos da Interface.

    @Autowired
    private PetRepository petRepository;

    @Autowired
    ScheduleRepository scheduleRepository;

    @Autowired
    private ClientRepository clientRepository;

    /**
     * Metodo que registra um pet no banco de dados
     * @param client
     * @return List<Pet>
     */
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

    /**
     * Metodo que busca todos os pets registrados no banco de dados
     * @return List<Pet>
     */
    @Override
    public List<Pet> listPet() {
        return petRepository.findAll();
    }

    /**
     * Metodo que busca um pet no banco de dados pelo ID
     * @param id
     * @return Pet
     */
    @Override
    public Pet showPet(Long id) {
        return petRepository.findById(id);
    }


    /**
     * Metodo que atualiza um pet no banco de dados pelo CPF do dono
     * @param client
     * @return List<Pet>
     */
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

    /**
     * Metodo que atualiza um pet no banco de dados pelo ID
     * @param pet
     * @return Pet
     */
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

    /**
     * Metodo que remove um pet no banco de dados pelo ID e CPF do dono
     * @param client
     */
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

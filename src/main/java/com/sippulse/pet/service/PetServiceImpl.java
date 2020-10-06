package com.sippulse.pet.service;

import com.sippulse.pet.entity.Client;
import com.sippulse.pet.entity.Pet;
import com.sippulse.pet.repository.ClientRepository;
import com.sippulse.pet.repository.PetRepository;
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
    private ClientRepository clientRepository;

    @Override
    public List<Pet> addPet(Client client) {
        Client clientPet = clientRepository.findByCpf(client.getCpf());
        Iterator<Pet> petIterator = client.getPets().iterator();
        List<Pet> petList = new ArrayList<>();
        while (petIterator.hasNext()){
            Pet pet = petIterator.next();
            if(petRepository.findByNameAndClient_Id(pet.getName(), clientPet.getId()) != null)
                pet = petIterator.next();
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
            Pet petToUpdate = petRepository.findByNameAndClient_Id(
                    pet.getName(),
                    clientRepository.findByCpf(client.getCpf()).getId());

            if (petToUpdate == null)
                    return null;
            if (!petToUpdate.getName().equals(pet.getName()))
                petToUpdate.setName(pet.getName());

            if (!petToUpdate.getBreed().equals(pet.getBreed()))
                petToUpdate.setBreed(pet.getBreed());

            if (!petToUpdate.getKind().equals(pet.getKind()))
                petToUpdate.setKind(pet.getKind());

            petList.add(petToUpdate);
            petRepository.save(petToUpdate);
        }


        return petList;
    }

    @Override
    public Pet updatePet(Pet pet) {
        Client client = petRepository.findById(pet.getId()).getClient();
        pet.setClient(client);
        return petRepository.save(pet);
    }

    @Override
    public void detelePet(Long id) {
        petRepository.delete(id);
    }
}

package com.sippulse.pet.service;

import com.sippulse.pet.entity.Pet;
import com.sippulse.pet.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetServiceImpl implements PetService{
// Implementação para os métodos da Interface.

    @Autowired
    private PetRepository petRepository;

    @Override
    public Pet addPet(Pet pet) {
        return petRepository.save(pet);
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
        return petRepository.findByClient(cpf);
    }

    @Override
    public List<Pet> listPetByVet(String email) {
        return petRepository.findByVets(email);
    }

    @Override
    public Pet updatePet(Pet pet) {
        return petRepository.save(pet);
    }

    @Override
    public void detelePet(Long id) {
        petRepository.delete(id);
    }
}

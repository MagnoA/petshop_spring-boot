package com.sippulse.pet.service;

import com.sippulse.pet.entity.Client;
import com.sippulse.pet.entity.Pet;

import java.util.List;

public interface PetService {
	// Interface para o Service

    public abstract List<Pet> addPet(Client client);
    public abstract List<Pet> listPet();
    public abstract Pet showPet(Long id);
    public abstract List<Pet> listPetByClient(String cpf);
    public abstract List<Pet> listPetByEmployee(String email);
    public abstract List<Pet> updatePet(Client client);
    public abstract Pet updatePet(Pet pet);
    public abstract void detelePet(Long id);
}

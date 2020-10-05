package com.sippulse.pet.service;

import com.sippulse.pet.entity.Pet;

import java.util.List;

public interface PetService {
	// Interface para o Service

    public abstract Pet addPet(Pet pet);
    public abstract List<Pet> listPet();
    public abstract Pet showPet(Long id);
    public abstract List<Pet> listPetByClient(String cpf);
    public abstract List<Pet> listPetByVet(String email);
    public abstract Pet updatePet(Pet pet);
    public abstract void detelePet(Long id);
}

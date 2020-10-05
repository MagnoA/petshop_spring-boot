package com.sippulse.pet.service;

import com.sippulse.pet.entity.Vet;

import java.util.List;

public interface VetService {

    public abstract Vet addVet(Vet vet);
    public abstract List<Vet> listVet();
    public abstract Vet showVet(Long id);
    public abstract Vet showVet(String email);
    public abstract Vet updateVet(Vet vet);
    public abstract void deteleVetById(Long id);
    public abstract void deleteVetByEmail(String email);
}

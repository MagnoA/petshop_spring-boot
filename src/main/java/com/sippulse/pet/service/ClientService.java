package com.sippulse.pet.service;

import com.sippulse.pet.entity.Client;
import com.sippulse.pet.entity.Pet;

import java.util.Collection;
import java.util.List;

public interface ClientService {

    public abstract Client addClient(Client client);
    public abstract Collection<Client> listClient();
    public abstract Client showClient(Long id);
    public abstract Client showClient(String cpf);
    public abstract List<Pet> showClientPets(String cpf);
    public abstract Client updateClient(Client client);
    public abstract void deteleClient(Long id);
    public abstract void deleteClient(String cpf);

}

package com.sippulse.pet.service;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sippulse.pet.entity.Client;
import com.sippulse.pet.entity.Pet;
import com.sippulse.pet.repository.ClientRepository;
import com.sippulse.pet.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/** Classe que implementa os Servicos requisitados pelo controller
 * @author Allex Magno
 * @version 1.0
 */

@Service
public class ClientServiceImpl implements ClientService{


    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PetRepository petRepository;

    @Override
    public Client addClient(Client client) {

        return clientRepository.save(client);
    }

    @Override
    public Collection<Client> listClient() { return clientRepository.findAll(); }

    @Override
    public Client showClient(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public Client showClient(String cpf) {
        return clientRepository.findByCpf(cpf);
    }

    @Override
    public List<Pet> showClientPets(String cpf) {
        Client client = clientRepository.findByCpf(cpf);
        return petRepository.findByClient(client);
    }

    @Override
    public Client updateClient(Client client) {
        Client clientToUpDate = clientRepository.findByCpf(client.getCpf());
        if (client.getAddress() != null)
            clientToUpDate.setAddress(client.getAddress());

        if (client.getName() != null)
            clientToUpDate.setName(client.getName());

        if (client.getCpf() != null)
            clientToUpDate.setCpf(client.getCpf());

        if(client.getTelephone() != null)
            clientToUpDate.setTelephone(client.getTelephone());

        return clientRepository.save(clientToUpDate);
    }

    @Override
    public void deteleClient(Long id) { clientRepository.delete(id);}

    @Override
    public void deleteClient(String cpf) { clientRepository.delete(clientRepository.findByCpf(cpf).getId()); }
}

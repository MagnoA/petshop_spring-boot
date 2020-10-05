package com.sippulse.pet.service;

import com.sippulse.pet.entity.Client;
import com.sippulse.pet.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/** Classe que implementa os Servicos requisitados pelo controller
 * @author Allex Magno
 * @version 1.0
 */

@Service
public class ClientServiceImpl implements ClientService{


    @Autowired
    private ClientRepository clientRepository;

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
    public Client updateClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public void deteleClient(Long id) { clientRepository.delete(id);}

    @Override
    public void deleteClient(String cpf) { clientRepository.delete(clientRepository.findByCpf(cpf).getId()); }
}

package com.sippulse.pet.service;

import com.sippulse.pet.entity.Client;
import com.sippulse.pet.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return null;
    }

    @Override
    public List<Client> listClient() {
        return null;
    }

    @Override
    public Client showClient(Long id) {
        return null;
    }

    @Override
    public Client showClient(String cpf) {
        return null;
    }

    @Override
    public Client updateClient(Client client) {
        return null;
    }

    @Override
    public void deteleClient(Long id) {

    }

    @Override
    public void deleteClient(String cpf) {

    }
}

package com.sippulse.pet.service;

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

    /**
     * Metodo para adicionar um cliente no bando de dados
     * @param client
     * @return Client
     */
    @Override
    public Client addClient(Client client) {

        return clientRepository.save(client);
    }

    /**
     * Metodo para buscor todos os clientes do banco de dados
     * @return List<Client>
     */
    @Override
    public Collection<Client> listClient() { return clientRepository.findAll(); }

    /**
     * Metodo para buscar um cliente pelo ID no banco de dados
     * @param id
     * @return Client
     */
    @Override
    public Client showClient(Long id) {
        return clientRepository.findById(id);
    }

    /**
     * Metodo para buscar um cliente pelo CPF
     * @param cpf
     * @return Client
     */
    @Override
    public Client showClient(String cpf) {
        return clientRepository.findByCpf(cpf);
    }

    /**
     * Metodo para buscar os pets no banco de dados
     * @param cpf
     * @return List<Pets>
     */
    @Override
    public List<Pet> showClientPets(String cpf) {
        Client client = clientRepository.findByCpf(cpf);
        return petRepository.findByClient(client);
    }

    /**
     * Metodo para atualizar um cliente no bando de dados
     * @param client
     * @return Client
     */
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

    /**
     * Metodo para deletar um cliente do banco de dados pelo ID
     * @param id
     */
    @Override
    public void deteleClient(Long id) { clientRepository.delete(id);}

    /**
     * Metodo para deletar um cliente do banco de dados pelo CPF
     * @param cpf
     */
    @Override
    public void deleteClient(String cpf) { clientRepository.delete(clientRepository.findByCpf(cpf).getId()); }
}

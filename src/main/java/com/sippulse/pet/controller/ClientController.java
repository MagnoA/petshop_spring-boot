package com.sippulse.pet.controller;


import com.sippulse.pet.entity.Client;
import com.sippulse.pet.service.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Classe controller que permite o gerenciamento de clientes
 */
@RestController
@RequestMapping(value = "clients")
public class ClientController {

    @Autowired
    private ClientServiceImpl clientService;

    /**
     * Metodo para busca de todos os clientes registrados no banco de dados
     * @return ResponseEntity HTTP 200 - JSON com todos os clientes
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> listClients(){
        return new ResponseEntity<>(clientService.listClient(), HttpStatus.OK);
    }

    /**
     * Metetodo que busca um cliente especifico por id
     * @param id
     * @return ResponseEntity HTTP 200 - JSON com as informacoes do cliente
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<?> getClientById(@PathVariable(value = "id") Long id){
        return new ResponseEntity<>(clientService.showClient(id), HttpStatus.OK);
    }

    /**
     * Metodo que busca por um cliente especifico por cpf
     * @param client
     * @return ResponseEntity HTTP 200 - JSON com as informacoes do cliente
     */
    @RequestMapping(method = RequestMethod.GET, value = "/cpf")
    public ResponseEntity<?> getClientByCpf(@RequestBody Client client){
        return new ResponseEntity<>(clientService.showClient(client.getCpf()), HttpStatus.OK);
    }

    /**
     * Metodo que busca os pets de determinado cliente
     * @param client
     * @return ResponseEntity HTTP 200 - JSON com os pets
     */
    @RequestMapping(method = RequestMethod.GET, value = "/cpf/pets")
    public ResponseEntity<?> getClientPets(@RequestBody Client client){
        return new ResponseEntity<>(clientService.showClientPets(client.getCpf()), HttpStatus.OK);
    }

    /**
     * Metodo para registro de um cliente
     * @param client
     * @return ResponseEntity HTTP 200 - JSON com as informacoes do cliente
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> registerClient(@RequestBody Client client){
        return new ResponseEntity<>(clientService.addClient(client), HttpStatus.OK);
    }

    /**
     * Metodo para a atualizacao de um cliente
     * @param client
     * @return ResponseEntity HTTP 200 - JSON com informacoes atualizadas
     */
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> updateClient(@RequestBody Client client){
        return new ResponseEntity<>(clientService.updateClient(client),HttpStatus.OK);
    }

    /**
     * Metodo que apaga um cliente do registro via ID
     * @param id
     * @return ResponseEntity HTTP 200 - JSON com demais funcionarios
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<?> deleteClientById(@PathVariable(value = "id") Long id){
        clientService.deteleClient(id);
        return new ResponseEntity<>(clientService.listClient(), HttpStatus.OK);
    }

    /**
     * Metodo que apaga o cliente pelo seu CPF
     * @param client
     * @return ResponseEntity HTTP 200 - JSON com demais funcionarios
     */
    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteClientByCpf(@RequestBody Client client){
        clientService.deleteClient(client.getCpf());
        return new ResponseEntity<>(clientService.listClient(), HttpStatus.OK);
    }
}

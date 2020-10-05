package com.sippulse.pet.controller;


import com.sippulse.pet.entity.Client;
import com.sippulse.pet.service.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Classe ClientController
 */
@RestController
@RequestMapping(value = "clients")
public class ClientController {

    @Autowired
    private ClientServiceImpl clientService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> listClients(){
        return new ResponseEntity<>(clientService.listClient(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<?> getClientById(@PathVariable(value = "id") Long id){
        return new ResponseEntity<>(clientService.showClient(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/cpf")
    public ResponseEntity<?> getClientByCpf(@RequestBody Client client){
        return new ResponseEntity<>(clientService.showClient(client.getCpf()), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public ResponseEntity<?> registerClient(@RequestBody Client client){
        return new ResponseEntity<>(clientService.addClient(client), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update")
    public ResponseEntity<?> updateClient(@RequestBody Client client){
        return new ResponseEntity<>(clientService.updateClient(client),HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
    public ResponseEntity<?> deleteClientById(@PathVariable(value = "id") Long id){
        clientService.deteleClient(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/cpf")
    public ResponseEntity<?> deleteClientByCpf(@RequestBody Client client){
        clientService.deleteClient(client.getCpf());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

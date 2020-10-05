package com.sippulse.pet.controller;

import com.sippulse.pet.entity.Client;
import com.sippulse.pet.entity.Pet;
import com.sippulse.pet.service.ClientServiceImpl;
import com.sippulse.pet.service.PetServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "pets")
public class PetController {
 // TODO - Completar com os Endpoints

    @Autowired
    private PetServiceImpl petService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> listPets(){
        return new ResponseEntity<>(petService.listPet(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<?> getPetById(@PathVariable(value = "id") Long id){
        return new ResponseEntity<>(petService.showPet(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> registerClient(@RequestBody Client client){
        return new ResponseEntity<>(petService.addPet(client), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> updateClient(@RequestBody Client client){
        return new ResponseEntity<>(petService.updatePet(client),HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public ResponseEntity<?> updateClient(@RequestBody Pet pet){
        return new ResponseEntity<>(petService.updatePet(pet),HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<?> deleteClientById(@PathVariable(value = "id") Long id){
        petService.detelePet(id);
        return new ResponseEntity<>(petService.listPet(), HttpStatus.OK);
    }
}
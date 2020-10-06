package com.sippulse.pet.controller;

import com.sippulse.pet.entity.Client;
import com.sippulse.pet.entity.Pet;
import com.sippulse.pet.service.PetServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Classe controller que permite gerenciar pets
 */

@RestController
@RequestMapping(value = "pets")
public class PetController {
 // TODO - Completar com os Endpoints

    @Autowired
    private PetServiceImpl petService;

    /**
     * Metodo que busca todos os pets registrados
     * @return ResponseEntity HTTP 200 - JSON com todos os pets
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> listPets(){
        return new ResponseEntity<>(petService.listPet(), HttpStatus.OK);
    }

    /**
     * Metodo que busca um pet pelo ID
     * @param id
     * @return ResponseEntity HTTP 200 - JSON com as informacoes do pet
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<?> getPetById(@PathVariable(value = "id") Long id){
        return new ResponseEntity<>(petService.showPet(id), HttpStatus.OK);
    }

    /**
     * Metedo que registra um pet
     * @param client
     * @return ResponseEntity HTTP 200 - JSON com as informacoes do pet
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> registerPet(@RequestBody Client client){
        return new ResponseEntity<>(petService.addPet(client), HttpStatus.OK);
    }

    /**
     * Metodo que atualiza um pet pelo CPF do cliente
     * @param client
     * @return ResponseEntity HTTP 200 - JSON com as informacoes atualizadas do pet
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/client")
    public ResponseEntity<?> updatePet(@RequestBody Client client){
        return new ResponseEntity<>(petService.updatePet(client),HttpStatus.OK);
    }

    /**
     * Metodo que atualiza um pet pelo ID
     * @param pet
     * @return ResponseEntity HTTP 200 - JSON com as informacoes atualizadas do pet
     */
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> updatePet(@RequestBody Pet pet){
        return new ResponseEntity<>(petService.updatePet(pet),HttpStatus.OK);
    }

    /**
     * Metodo que remove um pet da base de daods
     * @param client
     * @return ResponseEntity HTTP 200
     */
    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<?> deletePet(@RequestBody Client client){
        petService.detelePet(client);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
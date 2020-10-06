package com.sippulse.pet.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.List;

/**Classe DAO para entidade Client com metodos basicos como construtores, getters e setters;
 * @author Allex Magno
 * @version 1.0
 */

@Entity
@Table(name="tb_client")
public class Client extends AbstractEntity{

    @NotBlank
    private String name;

    @NotBlank
    private String telephone;

    @NotBlank
    private String address;

    @NotBlank
    @Column(unique = true)
    private String cpf;

    @JsonManagedReference(value = "client_pets")
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Pet> pets;

    public Client(){}

    public Client(String name, String address, String telephone, String cpf) {
        this.name = name;
        this.address = address;
        this.telephone = telephone;
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }
}

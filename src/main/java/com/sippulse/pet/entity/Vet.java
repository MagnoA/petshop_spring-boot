package com.sippulse.pet.entity;


import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.List;

/**Classe DAO para entidade Vet com metodos basicos como construtores, getters e setters;
 * @author Allex Magno
 * @version 1.0
 */

@Entity
@Table(name="tb_vet")
public class Vet extends AbstractEntity{

    @NotBlank
    private String name;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String role;

    @ManyToMany(mappedBy = "vets", cascade = CascadeType.ALL)
    private List<Pet> pets;

    public Vet(){}

    public Vet(String name, String email, String password, String role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }
}

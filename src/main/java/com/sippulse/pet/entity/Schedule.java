package com.sippulse.pet.entity;


import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_schedule")
public class Schedule extends AbstractEntity {

    @ManyToOne
    private Employee employee;

    @ManyToOne
    private Pet pet;

    public Schedule(){}

    public Schedule(Employee employee, Pet pet) {
        this.employee = employee;
        this.pet = pet;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}

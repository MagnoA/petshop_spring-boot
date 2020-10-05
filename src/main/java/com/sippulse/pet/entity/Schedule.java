package com.sippulse.pet.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_schedule")
public class Schedule extends AbstractEntity {

    @JsonBackReference(value = "employee_schedule")
    @ManyToOne
    @JoinColumn(name = "ID_EMPLOYEE", nullable = false)
    private  Employee employee;

    @JsonBackReference(value = "pet_schedule")
    @ManyToOne
    @JoinColumn(name = "ID_PET", nullable = false)
    private Pet pet;

    private LocalDateTime localDateTime;

    public Schedule(Employee employee, Pet pet, LocalDateTime localDateTime) {
        this.employee = employee;
        this.pet = pet;
        this.localDateTime = localDateTime;
    }

    public Schedule() {
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

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}

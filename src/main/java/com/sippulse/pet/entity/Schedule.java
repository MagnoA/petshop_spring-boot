package com.sippulse.pet.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.*;
import java.util.Date;

/**Classe DAO para o relacionamento SCHEDULE com metodos basicos como construtores, getters e setters;
 * @author Allex Magno
 * @version 1.0
 */

@Entity
@Table(name = "tb_schedule")
public class Schedule extends AbstractEntity {

    @JsonBackReference(value = "employee_schedule")
    @ManyToOne
    @JoinColumn(name = "ID_EMPLOYEE", nullable = false)
    private Employee employee;

    @JsonBackReference(value = "pet_schedule")
    @ManyToOne
    @JoinColumn(name = "ID_PET", nullable = false)
    private Pet pet;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @Temporal(TemporalType.TIME)
    @JsonFormat(pattern = "HH:mm")
    private Date time;

    public Schedule(Employee employee, Pet pet, Date date, Date time) {
        this.employee = employee;
        this.pet = pet;
        this.date = date;
        this.time = time;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}

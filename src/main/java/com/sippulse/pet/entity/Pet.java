package com.sippulse.pet.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.validator.constraints.NotBlank;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**Classe DAO para entidade PET com metodos basicos como construtores, getters e setters;
 * @author Allex Magno
 * @version 1.0
 */
@Entity
@Table(name="tb_pet")
public class Pet extends AbstractEntity {

	@NotBlank
	private String name;

	@NotBlank
	private String kind;

	@NotBlank
	private String breed;

	@JsonManagedReference(value = "pet_schedule")
	@OneToMany
	@JoinColumn(name = "ID_PET")
	private List<Schedule> schedules;

	@JsonBackReference(value = "client_pets")
	@ManyToOne
	@JoinColumn(name = "ID_CLIENT", nullable = false)
	private Client client;

	public Pet(String name, String kind, String breed) {
		this.name = name;
		this.kind = kind;
		this.breed = breed;
	}

	public Pet() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Schedule> getSchedules() {
		return schedules;
	}
	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}
}

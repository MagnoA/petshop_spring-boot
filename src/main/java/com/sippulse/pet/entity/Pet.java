package com.sippulse.pet.entity;


import org.hibernate.validator.constraints.NotBlank;
import javax.persistence.*;
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

	@ManyToOne
	@JoinColumn(name = "CLIENT_ID")
	private Client client;

	@ManyToMany
	@JoinTable(name="TB_SCHEDULE",
			joinColumns = @JoinColumn(name = "PET_ID"),
			inverseJoinColumns = @JoinColumn(name = "EMPLOYEE_ID"))
	private List<Employee> employees;

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

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
}

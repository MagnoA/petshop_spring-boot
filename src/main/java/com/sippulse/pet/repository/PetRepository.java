package com.sippulse.pet.repository;

import com.sippulse.pet.entity.Client;
import com.sippulse.pet.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**Interface de persistencia ORM da Entidade Pet, utilizando JPA
 *
 */
@Repository
public interface PetRepository extends JpaRepository<Pet,Long> {

    Pet findById(Long id);

    List<Pet> findByClient(Client client);

    Pet findByNameAndClient_Id(String name, Long clientId);
}

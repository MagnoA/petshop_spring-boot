package com.sippulse.pet.repository;

import com.sippulse.pet.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**Interface de persistencia ORM da Entidade Pet, utilizando JPA
 *
 */
@Repository
public interface PetRepository extends JpaRepository<Pet,Long> {
}

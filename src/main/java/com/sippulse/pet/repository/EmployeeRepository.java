package com.sippulse.pet.repository;

import com.sippulse.pet.entity.Vet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**Interface de persistencia ORM da Entidade Vet, utilizando JPA
 *
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Vet, Long> {
}

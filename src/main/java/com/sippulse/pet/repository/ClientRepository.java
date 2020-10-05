package com.sippulse.pet.repository;

import com.sippulse.pet.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**Interface de persistencia ORM da Entidade Client, utilizando JPA
 *
 */
@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {

    Client findById(Long id);

    Client findByCpf(String cpf);
}

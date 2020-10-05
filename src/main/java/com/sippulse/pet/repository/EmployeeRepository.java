package com.sippulse.pet.repository;

import com.sippulse.pet.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**Interface de persistencia ORM da Entidade Employee, utilizando JPA
 *
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findById(Long id);

    Employee findByEmail(String email);
}

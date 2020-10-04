package com.sippulse.pet.repository;

import com.sippulse.pet.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**Interface de persistencia ORM do Relacionamento Schedule, utilizando JPA
 *
 */

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}

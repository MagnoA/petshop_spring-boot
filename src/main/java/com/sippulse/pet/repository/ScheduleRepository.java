package com.sippulse.pet.repository;

import com.sippulse.pet.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    Schedule findById(Long id);
    List<Schedule> findByDate(Date date);
}

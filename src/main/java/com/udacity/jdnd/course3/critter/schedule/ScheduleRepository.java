package com.udacity.jdnd.course3.critter.schedule;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ScheduleRepository extends CrudRepository<Schedule, Long> {
    List<ScheduleDTO> getScheduleForUser(Long userId);
    List<ScheduleDTO> getScheduleForCustomer(Long customerId);
    List<ScheduleDTO> getScheduleForPet(Long petId);
    List<ScheduleDTO> getAllSchedules();
}

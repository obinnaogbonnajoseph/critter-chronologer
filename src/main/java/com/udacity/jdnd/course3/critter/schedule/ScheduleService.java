package com.udacity.jdnd.course3.critter.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    public ScheduleDTO createSchedule(Schedule schedule) {
        return new ScheduleDTO(scheduleRepository.save(schedule));
    }

    public List<ScheduleDTO> getAllSchedules() {
        return scheduleRepository.getAllSchedules();
    }

    public List<ScheduleDTO> getScheduleForPet(Long petId) {
        return scheduleRepository.getScheduleForPet(petId);
    }

    public List<ScheduleDTO> getScheduleForEmployee(Long employeeId) {
        return scheduleRepository.getScheduleForUser(employeeId);
    }

    public List<ScheduleDTO> getScheduleForCustomer(Long customerId) {
        return scheduleRepository.getScheduleForCustomer(customerId);
    }
}

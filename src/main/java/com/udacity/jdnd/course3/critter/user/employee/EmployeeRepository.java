package com.udacity.jdnd.course3.critter.user.employee;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.DayOfWeek;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findEmployeesAvailable(DayOfWeek day);
}

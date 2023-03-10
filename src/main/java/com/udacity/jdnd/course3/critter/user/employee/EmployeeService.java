package com.udacity.jdnd.course3.critter.user.employee;

import com.udacity.jdnd.course3.critter.user.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeDTO save(Employee employee) {
        return new EmployeeDTO(employeeRepository.save(employee));
    }

    public EmployeeDTO getEmployee(Long employeeId) throws UserNotFoundException {
        return new EmployeeDTO(employeeRepository.findById(employeeId).orElseThrow(UserNotFoundException::new));
    }

    public void setAvailability(Set<DayOfWeek> daysAvailable, Long employeeId) throws UserNotFoundException {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(UserNotFoundException::new);
        employee.setDaysAvailable(daysAvailable);
        employeeRepository.save(employee);
    }

    public List<EmployeeDTO> findEmployeesForService(EmployeeRequestDTO requestDTO) {
        List<EmployeeDTO> availableEmployees = employeeRepository.findEmployeesAvailable(requestDTO.getDate()
                        .getDayOfWeek())
                .stream().map(EmployeeDTO::new)
                .collect(Collectors.toList());
        return availableEmployees.stream()
                .filter(employeeDTO -> employeeDTO.getSkills()
                        .containsAll(requestDTO.getSkills()))
                .collect(Collectors.toList());
    }
}

package com.udacity.jdnd.course3.critter.user.employee;

import com.udacity.jdnd.course3.critter.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotEmpty;
import java.time.DayOfWeek;
import java.util.Set;

@Entity
@Getter
@Setter
@NamedQuery(name = "Employee.findEmployeesAvailable",
        query = "select e from Employee e, " +
                "in(e.daysAvailable) d " +
                "where d = :day"
)
public class Employee extends User {
    @ElementCollection(fetch = FetchType.LAZY)
    @NotEmpty
    private Set<EmployeeSkill> skills;
    @ElementCollection(fetch = FetchType.LAZY)
    private Set<DayOfWeek> daysAvailable;
}

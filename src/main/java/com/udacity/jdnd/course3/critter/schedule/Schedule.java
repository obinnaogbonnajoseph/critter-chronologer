package com.udacity.jdnd.course3.critter.schedule;

import com.udacity.jdnd.course3.critter.pet.Pet;
import com.udacity.jdnd.course3.critter.user.User;
import com.udacity.jdnd.course3.critter.user.employee.EmployeeSkill;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NamedQueries({
        @NamedQuery(
                name = "Schedule.getScheduleForUser",
                query = "select distinct new com.udacity.jdnd.course3.critter.schedule.ScheduleDTO(s) " +
                        "from Schedule s, " +
                        "in(s.users) user where user.id = :userId"
        ),
        @NamedQuery(
               name = "Schedule.getAllSchedules",
               query = "select distinct new com.udacity.jdnd.course3.critter.schedule.ScheduleDTO(s) " +
                       "from Schedule s"
        ),
        @NamedQuery(
                name = "Schedule.getScheduleForPet",
                query = "select distinct new com.udacity.jdnd.course3.critter.schedule.ScheduleDTO(s) " +
                        "from Schedule s, " +
                        "in(s.pets) pet where pet.id = :petId"
        ),
        @NamedQuery(
                name = "Schedule.getScheduleForCustomer",
                query = "select distinct new com.udacity.jdnd.course3.critter.schedule.ScheduleDTO(sch) " +
                        "from Schedule sch, " +
                        "in(sch.pets) pet " +
                        "where pet.owner.id = (select c.id from Customer c where c.id = :customerId)"
        )
})
public class Schedule {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.PRIVATE)
    private Long id;
    @ManyToMany
    @JoinTable(
            name = "schedule_user",
            joinColumns = {@JoinColumn(name = "schedule_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")}
    )
    private List<User> users;
    @ManyToMany
    @JoinTable(
            name = "schedule_pet",
            joinColumns = {@JoinColumn(name = "schedule_id")},
            inverseJoinColumns = {@JoinColumn(name = "pet_id")}
    )
    private List<Pet> pets;
    private LocalDate date;
    @ElementCollection(fetch = FetchType.LAZY)
    private Set<EmployeeSkill> activities;
}

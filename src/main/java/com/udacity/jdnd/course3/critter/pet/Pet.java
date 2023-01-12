package com.udacity.jdnd.course3.critter.pet;

import com.udacity.jdnd.course3.critter.user.customer.Customer;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Pet {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.PRIVATE)
    private Long id;
    @Column(length = 500)
    private String notes;
    @Nationalized
    @NotBlank
    private String name;
    private LocalDate birthDate;
    @Enumerated(EnumType.STRING)
    private PetType type;
    @ManyToOne
    @NotNull
    private Customer owner;
}

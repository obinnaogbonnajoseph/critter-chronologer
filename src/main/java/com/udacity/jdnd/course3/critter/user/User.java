package com.udacity.jdnd.course3.critter.user;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.PRIVATE)
    private Long id;
    @Nationalized
    @NotBlank
    private String name;
}

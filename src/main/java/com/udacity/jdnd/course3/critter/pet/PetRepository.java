package com.udacity.jdnd.course3.critter.pet;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PetRepository extends CrudRepository<Pet, Long> {
    List<Pet> findAllByOwner_Id(Long ownerId);
}

package com.udacity.jdnd.course3.critter.pet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PetService {

    @Autowired
    private PetRepository petRepository;

    public PetDTO save(Pet pet) {
        return new PetDTO(petRepository.save(pet));
    }

    public PetDTO getPet(Long petId) {
        return new PetDTO(petRepository.findById(petId).orElseThrow(RuntimeException::new));
    }

    public Pet findById(Long petId) {
        return petRepository.findById(petId).orElseThrow(RuntimeException::new);
    }

    public List<PetDTO> getPets() {
        List<PetDTO> petDTOS = new ArrayList<>();
        Iterable<Pet> pets = petRepository.findAll();
        pets.forEach(pet -> petDTOS.add(new PetDTO(pet)));
        return petDTOS;
    }

    public List<PetDTO> getPetsByOwner(Long ownerId) {
        return petRepository.findAllByOwner_Id(ownerId)
                .stream().map(PetDTO::new)
                .collect(Collectors.toList());
    }
}

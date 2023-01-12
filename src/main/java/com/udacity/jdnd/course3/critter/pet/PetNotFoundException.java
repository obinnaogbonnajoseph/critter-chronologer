package com.udacity.jdnd.course3.critter.pet;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@NoArgsConstructor
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Pet not found")
public class PetNotFoundException extends Exception {
    public PetNotFoundException(String message) {
        super(message);
    }
}

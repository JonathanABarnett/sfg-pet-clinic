package com.alaythiaproductions.sfgpetclinic.repositories;

import com.alaythiaproductions.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}

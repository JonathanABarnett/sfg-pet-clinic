package com.alaythiaproductions.sfgpetclinic.repositories;

import com.alaythiaproductions.sfgpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Visit, Long> {
}

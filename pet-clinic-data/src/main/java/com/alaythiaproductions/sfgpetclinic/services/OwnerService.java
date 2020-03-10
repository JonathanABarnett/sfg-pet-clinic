package com.alaythiaproductions.sfgpetclinic.services;

import com.alaythiaproductions.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}

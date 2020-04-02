package com.alaythiaproductions.sfgpetclinic.services.map;

import com.alaythiaproductions.sfgpetclinic.model.Speciality;
import com.alaythiaproductions.sfgpetclinic.services.SpecialitiesService;

import java.util.Set;

public class SpecialtyMapService extends AbstractMapService<Speciality, Long> implements SpecialitiesService {
    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public Speciality findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Speciality save(Speciality speciality) {
        return super.save(speciality);
    }

    @Override
    public void delete(Speciality speciality) {
        super.delete(speciality);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

}

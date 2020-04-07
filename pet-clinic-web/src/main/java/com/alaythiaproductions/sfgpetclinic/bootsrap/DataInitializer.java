package com.alaythiaproductions.sfgpetclinic.bootsrap;

import com.alaythiaproductions.sfgpetclinic.model.*;
import com.alaythiaproductions.sfgpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataInitializer implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataInitializer(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDensitry = specialityService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Crichton");
        owner1.setAddress("123 Main St");
        owner1.setCity("Springfield");
        owner1.setTelephone("888-899-1234");

        Pet michaelsPet = new Pet();
        michaelsPet.setPetType(savedDogPetType);
        michaelsPet.setOwner(owner1);
        michaelsPet.setBirthDate(LocalDate.now());
        michaelsPet.setName("Luna");
        owner1.getPets().add(michaelsPet);

        ownerService.save(owner1);

        Visit dogVisit = new Visit();
        dogVisit.setPet(michaelsPet);
        dogVisit.setDate(LocalDate.now());
        dogVisit.setDescription("Eating too much grass");

        visitService.save(dogVisit);

        Owner owner2 = new Owner();
        owner2.setFirstName("Stephen");
        owner2.setLastName("King");
        owner2.setAddress("456 Main St");
        owner2.setCity("Springfield");
        owner2.setTelephone("888-111-9876");

        Pet stephensCat = new Pet();
        stephensCat.setName("Killer");
        stephensCat.setOwner(owner2);
        stephensCat.setBirthDate(LocalDate.now());
        stephensCat.setPetType(savedCatPetType);
        owner2.getPets().add(stephensCat);

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("John");
        vet1.setLastName("Malarky");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Marky");
        vet2.setLastName("Mark");
        vet2.getSpecialities().add(savedDensitry);

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
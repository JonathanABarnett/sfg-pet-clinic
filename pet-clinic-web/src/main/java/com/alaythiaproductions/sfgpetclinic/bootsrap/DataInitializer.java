package com.alaythiaproductions.sfgpetclinic.bootsrap;

import com.alaythiaproductions.sfgpetclinic.model.Owner;
import com.alaythiaproductions.sfgpetclinic.model.PetType;
import com.alaythiaproductions.sfgpetclinic.model.Vet;
import com.alaythiaproductions.sfgpetclinic.services.OwnerService;
import com.alaythiaproductions.sfgpetclinic.services.PetTypeService;
import com.alaythiaproductions.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataInitializer(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Luna");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Killer");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Crichton");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Stephen");
        owner2.setLastName("King");

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("John");
        vet1.setLastName("Malarky");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Marky");
        vet2.setLastName("Mark");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
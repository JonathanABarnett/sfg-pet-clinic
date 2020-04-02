package com.alaythiaproductions.sfgpetclinic.bootsrap;

import com.alaythiaproductions.sfgpetclinic.model.Owner;
import com.alaythiaproductions.sfgpetclinic.model.Pet;
import com.alaythiaproductions.sfgpetclinic.model.PetType;
import com.alaythiaproductions.sfgpetclinic.model.Vet;
import com.alaythiaproductions.sfgpetclinic.services.OwnerService;
import com.alaythiaproductions.sfgpetclinic.services.PetTypeService;
import com.alaythiaproductions.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

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
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
       cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

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

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Marky");
        vet2.setLastName("Mark");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
package com.alaythiaproductions.sfgpetclinic.bootsrap;

import com.alaythiaproductions.sfgpetclinic.model.Owner;
import com.alaythiaproductions.sfgpetclinic.model.Vet;
import com.alaythiaproductions.sfgpetclinic.services.OwnerService;
import com.alaythiaproductions.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataInitializer(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Michael");
        owner1.setLastName("Crichton");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Stephen");
        owner2.setLastName("King");

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("John");
        vet1.setLastName("Malarky");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Marky");
        vet2.setLastName("Mark");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
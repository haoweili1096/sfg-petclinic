package haowei.springframework.sfgpetclinic.bootstrap;

import haowei.springframework.sfgpetclinic.model.PetType;
import haowei.springframework.sfgpetclinic.model.Speciality;
import haowei.springframework.sfgpetclinic.repositories.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Profile({"springdatajpa"})
public class BootStrapMySQL implements ApplicationListener<ContextRefreshedEvent> {
    private final OwnerRepository ownerRepository;
    private final VetRepository vetRepository;
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;
    private final SpecialtyRepository specialtyRepository;
    private final VisitRepository visitRepository;

    public BootStrapMySQL(OwnerRepository ownerRepository, VetRepository vetRepository, PetRepository petRepository, PetTypeRepository petTypeRepository, SpecialtyRepository specialtyRepository, VisitRepository visitRepository) {
        this.ownerRepository = ownerRepository;
        this.vetRepository = vetRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
        this.specialtyRepository = specialtyRepository;
        this.visitRepository = visitRepository;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if(petTypeRepository.count() == 0L){
            log.debug("Loading PetTypes");
            loadPetTypes();
        }

        if(specialtyRepository.count() == 0L){
            log.debug("Loading Specialties");
            loadSpecialties();
        }
    }

    private void loadPetTypes(){
        PetType dog = new PetType();
        dog.setName("Dog");
        petTypeRepository.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        petTypeRepository.save(cat);
    }

    private void loadSpecialties(){
        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        specialtyRepository.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        specialtyRepository.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("dentistry");
        specialtyRepository.save(dentistry);
    }
}

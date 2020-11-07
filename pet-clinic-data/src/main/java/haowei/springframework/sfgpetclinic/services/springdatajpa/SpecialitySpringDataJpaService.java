package haowei.springframework.sfgpetclinic.services.springdatajpa;

import haowei.springframework.sfgpetclinic.model.Speciality;
import haowei.springframework.sfgpetclinic.repositories.SpecialityRepository;
import haowei.springframework.sfgpetclinic.services.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class SpecialitySpringDataJpaService implements SpecialityService {

    private final SpecialityRepository specialityRepository;

    public SpecialitySpringDataJpaService(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specialities = new HashSet<>();

        specialityRepository.findAll().forEach(specialities::add);

        return specialities;
    }

    @Override
    public Speciality findById(Long aLong) {

        Optional<Speciality> optionalSpeciality = specialityRepository.findById(aLong);

        if(optionalSpeciality.isPresent()){
            return optionalSpeciality.get();
        }

        return null;
    }

    @Override
    public Speciality save(Speciality object) {
        return specialityRepository.save(object);
    }

    @Override
    public void delete(Speciality object) {
        specialityRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        specialityRepository.deleteById(aLong);
    }
}

package haowei.springframework.sfgpetclinic.services.springdatajpa;

import haowei.springframework.sfgpetclinic.model.Visit;
import haowei.springframework.sfgpetclinic.repositories.VisitRepository;
import haowei.springframework.sfgpetclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VisitSpringDataJpaService implements VisitService {

    private final VisitRepository visitRepository;

    public VisitSpringDataJpaService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> visits = new HashSet<>();

        visitRepository.findAll().forEach(visits::add);

        return visits;
    }

    @Override
    public Visit findById(Long aLong) {

        Optional<Visit> optionalVisit = visitRepository.findById(aLong);

        if(optionalVisit.isPresent()){
            return optionalVisit.get();
        }

        return null;
    }

    @Override
    public Visit save(Visit object) {
        return visitRepository.save(object);
    }

    @Override
    public void delete(Visit object) {
        visitRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        visitRepository.deleteById(aLong);
    }
}

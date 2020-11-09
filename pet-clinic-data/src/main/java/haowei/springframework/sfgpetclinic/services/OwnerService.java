package haowei.springframework.sfgpetclinic.services;

import haowei.springframework.sfgpetclinic.model.Owner;

import java.util.List;


public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);
    /*
    //with the CrudService, we do not need these any more
    Owner findById(Long id);

    Owner save(Owner owner);

    Set<Owner> findAll();

     */
}

package haowei.springframework.sfgpetclinic.services;

import haowei.springframework.sfgpetclinic.model.Owner;


public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);
    /*
    //with the CrudService, we do not need these any more
    Owner findById(Long id);

    Owner save(Owner owner);

    Set<Owner> findAll();

     */
}

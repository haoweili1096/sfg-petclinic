package haowei.springframework.sfgpetclinic.services;

import java.util.Set;

//这里是模仿CrudRepository加上的<T, ID>, 这俩叫做java generics
public interface CrudService<T, ID> {

    Set<T> findAll();

    T findById(ID id);

    T save(T object);

    void delete(T object);

    void deleteById(ID id);
}

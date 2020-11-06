package haowei.springframework.sfgpetclinic.services.map;

import haowei.springframework.sfgpetclinic.model.BaseEntity;

import java.util.*;

//这里有小技巧，因为这是一个抽象类，map.keySet() will be unhappy, 所以这里让ID extends Long,然后把Map里的ID变成Long,就可以了
//此外，T extends BaseEntity 是为了object.getId() 能够使用BaseEntity的方法
public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll(){
        return new HashSet<>(map.values());
    }

    T findById(ID id){
        return map.get(id);
    }

    //原本save(ID id, T object)
    //现在变得更strong，因为不再需要直到object的id了
    T save(T object){

        if(object != null){
            if(object.getId() == null){
                object.setId(getNextId());
            }

            map.put(object.getId(), object);
        }
        else{
            throw new RuntimeException("Object cannot be null");
        }

        return object;
    }

    void deleteById(ID id){
        map.remove(id);
    }

    void delete(T object){
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    private Long getNextId(){

        Long nextId = null;

        //最初的时候，map中没有对象，那么nextId = null
        try{
            nextId = Collections.max(map.keySet()) + 1;
        } catch (NoSuchElementException e){
            nextId = 1L;
        }

        return nextId;
    }


}

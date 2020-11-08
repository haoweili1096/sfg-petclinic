package haowei.springframework.sfgpetclinic.services.springdatajpa;

import haowei.springframework.sfgpetclinic.model.Owner;
import haowei.springframework.sfgpetclinic.repositories.OwnerRepository;
import haowei.springframework.sfgpetclinic.repositories.PetRepository;
import haowei.springframework.sfgpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

//set the JUint 5 environment for Mockito

@ExtendWith(MockitoExtension.class)
class OwnerSpringDataJpaServiceTest {

    public static final String LAST_NAME = "Smith";
    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSpringDataJpaService ownerSpringDataJpaService;

    Owner returnOwner;

    @BeforeEach
    void setUp() {
        returnOwner = Owner.builder().id(1L).lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName() {

        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);

        Owner smith = ownerSpringDataJpaService.findByLastName(LAST_NAME);

        assertEquals(LAST_NAME, smith.getLastName());

        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findAll() {

        Set<Owner> returnOwnerSet = new HashSet<>();
        returnOwnerSet.add(Owner.builder().id(1L).build());
        returnOwnerSet.add(Owner.builder().id(2L).build());

        when(ownerRepository.findAll()).thenReturn(returnOwnerSet);

        Set<Owner> owners = ownerSpringDataJpaService.findAll();

        assertNotNull(owners);
        assertEquals(2, owners.size());

    }

    @Test
    void findById() {

        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));

        Owner owner = ownerSpringDataJpaService.findById(1L);

        assertNotNull(owner);
    }

    @Test
    void findByIdNotNull() {

        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());

        Owner owner = ownerSpringDataJpaService.findById(1L);

        assertNull(owner);
    }

    @Test
    void save() {
        Owner ownerToSave = Owner.builder().id(1L).build();

        //when(xxxx).thenReturn(yyyy); 是指定当执行了这个方法的时候，返回 thenReturn 的值，相当于是对模拟对象的配置过程，为某些条件给定一个预期的返回值。
        when(ownerRepository.save(any())).thenReturn(returnOwner);

        Owner savedOwner = ownerSpringDataJpaService.save(ownerToSave);

        assertNotNull(savedOwner);

        //校验ownerRepository.save()方法是否被调用
        verify(ownerRepository).save(any());
    }

    @Test
    void delete() {

        ownerSpringDataJpaService.delete(returnOwner);

        //default is 1 time
        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        ownerSpringDataJpaService.deleteById(1L);

        verify(ownerRepository).deleteById(anyLong());
    }
}
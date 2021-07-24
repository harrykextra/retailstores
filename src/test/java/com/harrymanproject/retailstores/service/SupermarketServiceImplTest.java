package com.harrymanproject.retailstores.service;

import com.harrymanproject.retailstores.data.model.Supermarket;
import com.harrymanproject.retailstores.data.repository.SupermarketRepository;
import com.harrymanproject.retailstores.exceptions.SupermarketDoesNotExistException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@Slf4j
class SupermarketServiceImplTest {

    @Mock
    SupermarketRepository supermarketRepository;

    @InjectMocks
    SupermarketServiceImpl supermarketServiceImpl;

    Supermarket testSupermarket;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        testSupermarket = new Supermarket();
    }

    @Test
    void mockTheSaveSupermarketTest() throws SupermarketDoesNotExistException {
        supermarketServiceImpl.saveSupermarket(testSupermarket);
        verify(supermarketRepository, times(1)).save(testSupermarket);
    }

    @Test
    void mockTheUpdateSupermarketTest() throws SupermarketDoesNotExistException{
        supermarketServiceImpl.updateSupermarket(testSupermarket);
        verify(supermarketRepository, times(1)).save(testSupermarket);
    }

    @Test
    void mockTheFindSupermarketByIdTest(){
        when(supermarketRepository.findById(3)).thenReturn(Optional.of(testSupermarket));
        supermarketServiceImpl.findSupermarketById(3);
        verify(supermarketRepository, times(1)).findById(3);
    }

    @Test
    void mockTheDeleteSupermarketTest(){
        supermarketServiceImpl.deleteSupermarket(3);
        verify(supermarketRepository, times(1)).deleteById(3);
    }
}
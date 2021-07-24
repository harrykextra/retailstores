package com.harrymanproject.retailstores.datarepository;

import com.harrymanproject.retailstores.data.repository.SupermarketRepository;
import com.harrymanproject.retailstores.data.model.Supermarket;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@Slf4j
public class SupermarketRepositoryTest {

    @Autowired
    SupermarketRepository supermarketRepository;

    @Test
    void saveTest(){
        Supermarket supermarket = new Supermarket();
        supermarket.setName("Amazon Like");
        supermarket.setAddress("5, Dede street, Ikeja, Lagos");
        supermarket.setEmailAddress("amazonlike@gmail.com");
        supermarket.setContactNumber("090-1111-0000");

        supermarketRepository.save(supermarket);

        log.info("saving supermarket object---->{}");

        assertThat(supermarket.getId()).isNotNull();
    }

    @Test
    void findByIdTest(){
        Supermarket supermarket = supermarketRepository.findById(3).orElse(null);
        assertThat(supermarket.getId()).isEqualTo(3);
        log.info("find store by id--->{}",supermarket);

    }

    @Test
    void findAllTest(){
        List<Supermarket>  getAllSupermarkets = supermarketRepository.findAll();
        assertThat(getAllSupermarkets.size()).isEqualTo(3);
    }

    @Test
    void deleteByIdTest(){
        supermarketRepository.findById(5).orElse(null);
        supermarketRepository.deleteById(5);
        assertThat(supermarketRepository.existsById(5)).isFalse();
    }
}

package com.harrymanproject.retailstores.datarepository;

import com.harrymanproject.retailstores.data.model.Supermarket;
import com.harrymanproject.retailstores.data.repository.ItemRepository;
import com.harrymanproject.retailstores.data.repository.SupermarketRepository;
import com.harrymanproject.retailstores.data.model.Category;
import com.harrymanproject.retailstores.data.model.Item;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@Slf4j
public class ItemRepositoryTest {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    SupermarketRepository supermarketRepository;

    @BeforeEach
    void setUp(){
    }

    @Test
    void saveItemTest(){
        Item item = new Item();
        item.setName("Chese");
        item.setCategory(Category.FOOD);

        itemRepository.save(item);

        log.info(("saving item object--->{}"));

        assertThat(item.getId()).isNotNull();
    }

    @Test
    @Transactional
    @Rollback(value = false)
    void toMapListOfItemsToSupermarketTest(){
        Item item = new Item();
        Supermarket supermarket = new Supermarket();
        item.setName("Coca-cola");
        item.setCategory(Category.DRINKS);

        supermarket = supermarketRepository.findById(3).orElse(null);

        item.setSupermarket(supermarket);

        itemRepository.save(item);
        log.info("Mapping item to supermarket--->{}", item);
    }

    @Test
    void findByIdTest(){
        Item item = itemRepository.findById(1).orElse(null);
        assertThat(item.getId()).isEqualTo(1);
        log.info("find item by id --->{}", item);
    }

    @Test
    void findAllTest(){
        List<Item> items = itemRepository.findAll();
        assertThat(items.size()).isEqualTo(3);
    }

    @Test
    void deleteTest(){
        itemRepository.findById(2).orElse(null);
        itemRepository.deleteById(2);
        assertThat(itemRepository.existsById(2)).isFalse();
    }

}

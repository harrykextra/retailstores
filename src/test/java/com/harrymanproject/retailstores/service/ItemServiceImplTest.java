package com.harrymanproject.retailstores.service;

import com.harrymanproject.retailstores.data.model.Item;
import com.harrymanproject.retailstores.data.repository.ItemRepository;
import com.harrymanproject.retailstores.exceptions.ItemDoesNotExistException;
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
class ItemServiceImplTest {

    @Mock
    ItemRepository itemRepository;

    @InjectMocks
    ItemServiceImpl itemServiceImpl;

    Item testItem;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        testItem = new Item();
    }

    @Test
    void mockSaveItemTest() throws ItemDoesNotExistException{
        itemServiceImpl.saveItem(testItem);
        verify(itemRepository, times(1)).save(testItem);
    }

    @Test
    void mockTheUpdateTest() throws ItemDoesNotExistException{
        itemServiceImpl.updateItem(testItem);
        verify(itemRepository, times(1)).save(testItem);
    }

    @Test
    void mockTheFindItemByIdTest(){
        when(itemRepository.findById(1)).thenReturn(Optional.of(testItem));
        itemServiceImpl.findItemById(1);
        verify(itemRepository, times(1)).findById(1);
    }

    @Test
    void mockTheDeleteTest(){
        itemServiceImpl.deleteItem(1);
        verify(itemRepository, times(1)).deleteById(1);
    }
}
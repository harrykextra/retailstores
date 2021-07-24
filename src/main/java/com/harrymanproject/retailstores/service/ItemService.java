package com.harrymanproject.retailstores.service;

import com.harrymanproject.retailstores.data.model.Item;
import com.harrymanproject.retailstores.exceptions.ItemDoesNotExistException;

import java.util.List;

public interface ItemService {

    void saveItem (Item item) throws ItemDoesNotExistException;
    void updateItem(Item item) throws ItemDoesNotExistException;
    Item findItemById(Integer id);
    List<Item> findAllItems();
    void deleteItem (Integer id);

}

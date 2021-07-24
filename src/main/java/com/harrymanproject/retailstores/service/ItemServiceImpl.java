package com.harrymanproject.retailstores.service;

import com.harrymanproject.retailstores.data.model.Item;
import com.harrymanproject.retailstores.data.repository.ItemRepository;
import com.harrymanproject.retailstores.exceptions.ItemDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    ItemRepository itemRepository;

    @Override
    public void saveItem(Item item) throws ItemDoesNotExistException{
        if (item == null){
            throw new ItemDoesNotExistException("Item can not be null");
        }
        itemRepository.save(item);
    }

    @Override
    public void updateItem(Item item) throws ItemDoesNotExistException{
        if (item == null){
            throw new ItemDoesNotExistException("Item can not be null");
        }
        itemRepository.save(item);
    }

    @Override
    public Item findItemById(Integer id){
        return itemRepository.findById(id).orElse(null);
    }

    @Override
    public List<Item> findAllItems(){
        return itemRepository.findAll();
    }

    @Override
    public void deleteItem(Integer id){
        itemRepository.deleteById(id);
    }


}

package com.harrymanproject.retailstores.controller;

import com.harrymanproject.retailstores.data.model.Item;
import com.harrymanproject.retailstores.exceptions.ItemDoesNotExistException;
import com.harrymanproject.retailstores.service.ItemServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
@Slf4j
public class ItemController {

    @Autowired
    ItemServiceImpl itemServiceImpl;

    @PostMapping("/create")
    public ResponseEntity<?> saveItem(@RequestBody Item item){
        log.info("Request object ----> {}", item);
        try {
            itemServiceImpl.saveItem(item);
        }catch (ItemDoesNotExistException exe){
            return ResponseEntity.badRequest().body(exe.getMessage());
        }
        return new ResponseEntity<>(item, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllItems(){
        log.info("Get end point called");
        List<Item> itemList = itemServiceImpl.findAllItems();
        log.info("retrieve items from database---->{}", itemList);
        return ResponseEntity.ok().body(itemList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findOnePet(@PathVariable("id") Integer id){
        log.info("id of items to be found---->{}", id);
        Item item;
        item = itemServiceImpl.findItemById(id);

        return ResponseEntity.ok().body(item);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>deleteItem(@PathVariable Integer id){
        log.info("id of item to be found----->{}",id);
        itemServiceImpl.deleteItem(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

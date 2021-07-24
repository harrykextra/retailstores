package com.harrymanproject.retailstores.controller;

import com.harrymanproject.retailstores.data.model.Supermarket;
import com.harrymanproject.retailstores.exceptions.SupermarketDoesNotExistException;
import com.harrymanproject.retailstores.service.SupermarketServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/supermarket")
public class SupermarketController {

    @Autowired
    SupermarketServiceImpl supermarketServiceImpl;

    @PostMapping("/create")
    public ResponseEntity<?> saveSupermarket(@RequestBody Supermarket supermarket){
        log.info("Request object----->{}", supermarket);
        try {
            supermarketServiceImpl.saveSupermarket(supermarket);
        }catch (SupermarketDoesNotExistException exe){
            return ResponseEntity.badRequest().body(exe.getMessage());
        }
        return new ResponseEntity<>(supermarket, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllSupermarket(){
        log.info("Get end point called");
        List<Supermarket> supermarketList = supermarketServiceImpl.findAllSupermarkets();
        log.info("retireve supermarkets from database---->{}",supermarketList);
        return ResponseEntity.ok().body(supermarketList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>findOneSupermarket(@PathVariable("id") Integer id){
        log.info("id of supermarket to be found----->{}",id);
        Supermarket supermarket = supermarketServiceImpl.findSupermarketById(id);
        return ResponseEntity.ok().body(supermarket);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>deleteStore(@PathVariable Integer id){
        log.info("id of supermarket to be found", id);
        supermarketServiceImpl.deleteSupermarket(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

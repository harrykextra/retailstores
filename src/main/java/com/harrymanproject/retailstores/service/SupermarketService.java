package com.harrymanproject.retailstores.service;

import com.harrymanproject.retailstores.data.model.Supermarket;
import com.harrymanproject.retailstores.exceptions.SupermarketDoesNotExistException;

import java.util.List;

public interface SupermarketService {

    void saveSupermarket(Supermarket supermarket)throws SupermarketDoesNotExistException;
    void updateSupermarket(Supermarket supermarket) throws SupermarketDoesNotExistException;
    Supermarket findSupermarketById(Integer id);
    List<Supermarket> findAllSupermarkets();
    void deleteSupermarket(Integer id);
}

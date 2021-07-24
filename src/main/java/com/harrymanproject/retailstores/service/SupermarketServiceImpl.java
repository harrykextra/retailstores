package com.harrymanproject.retailstores.service;

import com.harrymanproject.retailstores.data.model.Supermarket;
import com.harrymanproject.retailstores.data.repository.SupermarketRepository;
import com.harrymanproject.retailstores.exceptions.SupermarketDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupermarketServiceImpl implements SupermarketService{

    @Autowired
    SupermarketRepository supermarketRepository;

    @Override
    public void saveSupermarket(Supermarket supermarket)throws SupermarketDoesNotExistException{
       if (supermarket == null){
           throw new SupermarketDoesNotExistException("Supermarket can not be null");
       }
        supermarketRepository.save(supermarket);
    }

    @Override
    public void updateSupermarket(Supermarket supermarket)throws SupermarketDoesNotExistException{
        if (supermarket == null){
            throw new SupermarketDoesNotExistException("Supermarket can not be null");
        }
        supermarketRepository.save(supermarket);
    }

    @Override
    public Supermarket findSupermarketById(Integer id){
        return supermarketRepository.findById(id).orElse(null);
    }

    @Override
    public List<Supermarket> findAllSupermarkets(){
        return supermarketRepository.findAll();
    }

    @Override
    public void deleteSupermarket(Integer id){
        supermarketRepository.deleteById(id);
    }
}

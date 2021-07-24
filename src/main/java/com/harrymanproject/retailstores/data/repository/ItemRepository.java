package com.harrymanproject.retailstores.data.repository;

import com.harrymanproject.retailstores.data.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Integer>{
}

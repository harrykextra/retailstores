package com.harrymanproject.retailstores.data.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Supermarket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String address;
    private String emailAddress;
    private String contactNumber;

    @OneToMany( cascade = {CascadeType.PERSIST},orphanRemoval = true, fetch = FetchType.EAGER)
    List<Item> itemList;

    public void addItem(Item item){
        if (itemList == null){
            itemList = new ArrayList<>();
        }
        itemList.add(item);
    }



}

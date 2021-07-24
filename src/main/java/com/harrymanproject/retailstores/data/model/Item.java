package com.harrymanproject.retailstores.data.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Category category;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @ToString.Exclude
    @JsonIgnore
    Supermarket supermarket;
}

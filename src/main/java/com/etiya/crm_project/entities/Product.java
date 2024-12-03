package com.etiya.crm_project.entities;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;
    @Column(name="unitPrice")
    private double unitPrice;


}


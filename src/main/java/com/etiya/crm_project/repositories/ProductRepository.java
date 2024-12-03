package com.etiya.crm_project.repositories;

import com.etiya.crm_project.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    Optional<Product> findByNameIgnoreCase(String name);//abc
}

//select * from products where name = "abc"

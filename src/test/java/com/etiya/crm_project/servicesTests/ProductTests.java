package com.etiya.crm_project.servicesTests;

import com.etiya.crm_project.entities.Product;
import com.etiya.crm_project.repositories.ProductRepository;
import com.etiya.crm_project.services.ProductService;
import com.etiya.crm_project.services.ProductServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductTests {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    public ProductTests(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void productNameCannotBeDuplicated(){


        Product product1 = new Product();
        product1.setName("dfghfghdfghfd");
        product1.setUnitPrice(12);

        productService.add(product1);

        Product product2 = new Product();
        product2.setName("dfghfghdfghfd");
        product2.setUnitPrice(12);

        when(productRepository.findByNameIgnoreCase(any(String.class))).thenReturn(Optional.of(product1));

        assertThrows(RuntimeException.class,()->productService.add(product2));

    }
}

package com.etiya.crm_project.services;

import com.etiya.crm_project.entities.Product;
import com.etiya.crm_project.repositories.ProductRepository;
import com.etiya.crm_project.rules.ProductBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{
    private ProductRepository productRepository;
    private ProductBusinessRules productBusinessRules;
    @Override
    public Product add(Product product) {

        productBusinessRules.productNameCanNotBeDuplicated(product.getName());

        Product createdProduct = productRepository.save(product);
        return createdProduct;
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product update(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void delete(int id) {
         productRepository.deleteById(id);
    }


}

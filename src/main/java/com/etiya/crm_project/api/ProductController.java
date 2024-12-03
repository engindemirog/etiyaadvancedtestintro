package com.etiya.crm_project.api;

import com.etiya.crm_project.entities.Product;
import com.etiya.crm_project.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {
    private ProductService productService;

    @PostMapping
    public Product add(@RequestBody Product product){
        return productService.add(product);

    }

    @GetMapping
    public List<Product> getAll(){
        return productService.getAll();
    }

    @PutMapping
    public Product update(@RequestBody Product product){
        return productService.update(product);
    }

    @DeleteMapping
    public void delete(@RequestParam(value="id") int id){
        productService.delete(id);
    }
}


//Customer-->id,firstName,lastName,age
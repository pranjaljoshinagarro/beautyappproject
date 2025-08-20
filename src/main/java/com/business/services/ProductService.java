package com.business.services;

import com.business.entities.Product;
import com.business.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Save a new product
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    // Get all products
    @Cacheable(value = "products")
    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }

    // Get a single product
    @Cacheable(value = "product", key = "#id")
    public Product getProduct(int id) {
        Optional<Product> optional = productRepository.findById(id);
        return optional.orElse(null);
    }

    // Update product
    @CachePut(value = "product", key = "#id")
    public Product updateProduct(Product p, int id) {
        p.setPid(id);
        Optional<Product> optional = productRepository.findById(id);
        if (optional.isPresent()) {
            return productRepository.save(p);
        }
        return null;
    }

    // Delete product
    @CacheEvict(value = "product", key = "#id")
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }
}


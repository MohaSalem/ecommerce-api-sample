package com.mora.api.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public void addProduct(Product product) {
        Optional<Product> productOptional = productRepository.findProductByName(product.getName());
        if (productOptional.isPresent()){
            throw new IllegalStateException("Product already exists, publish with different name");
        }
        productRepository.save(product);
    }

    public void deleteProduct(Long productId) {
        boolean isPresent = productRepository.existsById(productId);
        if (!isPresent){
            throw new IllegalStateException("Product with id " + productId + " does not exist");
        }
        productRepository.deleteById(productId);
    }

    @Transactional
    public void updateStudent(Long productId, String name, String description, Double price) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new IllegalStateException("Product with id " + productId + " does not exist"));
        if (name != null && !name.equals(product.getName()) && name.length() > 0) {
            product.setName(name);
        }

        if (description != null && !description.equals(product.getDescription()) && description.length() > 0) {
            product.setDescription(description);
        }

        if (price != null && !price.equals(product.getPrice())) {
            product.setPrice(price);
        }
    }
}

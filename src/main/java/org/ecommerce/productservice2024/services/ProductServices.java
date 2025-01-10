package org.ecommerce.productservice2024.services;

import org.ecommerce.productservice2024.models.Product;

import java.util.List;

public interface ProductServices {
    Product getSingleProduct(Long productId);
    List<Product> getAllProduct();
    Product updateProduct(Long id,Product product);
    Product replaceProduct(Long id, Product product);
}

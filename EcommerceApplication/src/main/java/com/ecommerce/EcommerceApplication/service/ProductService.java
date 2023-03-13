package com.ecommerce.EcommerceApplication.service;


import com.ecommerce.EcommerceApplication.model.Product;
import com.ecommerce.EcommerceApplication.payload.ProductDto;

import java.util.List;

public interface ProductService
{
    ProductDto createProduct(ProductDto productDto,Integer userId,Integer categoryId);
    ProductDto updateProduct(ProductDto productDto,Integer productId);
    void deleteProduct(Integer productId);
    ProductDto getProductById(Integer productId);
    List<ProductDto> getAllProducts();

    List<ProductDto> getProductByCategory(Integer categoryId);

    List<ProductDto> getProductByUser(Integer userId);

    List<Product> searchProduct(String keyword);
}

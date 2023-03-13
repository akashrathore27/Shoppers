package com.ecommerce.EcommerceApplication.service.implementation;

import com.ecommerce.EcommerceApplication.exception.ResourceNotFoundException;
import com.ecommerce.EcommerceApplication.model.Category;
import com.ecommerce.EcommerceApplication.model.Product;
import com.ecommerce.EcommerceApplication.model.User;
import com.ecommerce.EcommerceApplication.payload.ProductDto;
import com.ecommerce.EcommerceApplication.payload.UserDto;
import com.ecommerce.EcommerceApplication.repository.CategoryRepository;
import com.ecommerce.EcommerceApplication.repository.ProductRepository;
import com.ecommerce.EcommerceApplication.repository.UserRepository;
import com.ecommerce.EcommerceApplication.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImplementation implements ProductService
{


    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public ProductDto createProduct(ProductDto productDto,Integer userId,Integer categoryId) {

        User user=this.userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("user","userId",userId));

        Category category=this.categoryRepository.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("category","categoryId",categoryId));

        Product product=this.modelMapper.map(productDto,Product.class);
        product.setProductImage("default.png");
        product.setAddedDate(new Date());
        product.setUser(user);
        product.setCategory(category);

        Product saveProduct=this.productRepository.save(product);

        return this.modelMapper.map(saveProduct,ProductDto.class);


    }

    @Override
    public ProductDto updateProduct(ProductDto productDto, Integer productId) {
        return null;
    }

    @Override
    public void deleteProduct(Integer productId) {

    }

    @Override
    public ProductDto getProductById(Integer productId)
    {
        Product product=this.productRepository.findById(productId).orElseThrow(()->new ResourceNotFoundException("product","productId",productId));
        return this.modelMapper.map(product,ProductDto.class);
    }

    @Override
    public List<ProductDto> getAllProducts()
    {
        List<Product> productList=this.productRepository.findAll();
        List<ProductDto>productDtoList=productList.stream().map(product -> this.modelMapper.map(product,ProductDto.class)).collect(Collectors.toList());
        return productDtoList;
    }

    @Override
    public List<ProductDto> getProductByCategory(Integer categoryId)
    {
        Category category=this.categoryRepository.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("category","categoryId",categoryId));
        List<Product> productList=this.productRepository.findByCategory(category);
        List<ProductDto>productDtoList=productList.stream().map(product -> this.modelMapper.map(product,ProductDto.class)).collect(Collectors.toList());
        return productDtoList;
    }

    @Override
    public List<ProductDto> getProductByUser(Integer userId)
    {
        User user=this.userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("user","userId",userId));
        List<Product> productList=this.productRepository.findByUser(user);
        List<ProductDto>productDtoList=productList.stream().map(product -> this.modelMapper.map(product,ProductDto.class)).collect(Collectors.toList());
        return productDtoList;
    }

    @Override
    public List<Product> searchProduct(String keyword) {
        return null;
    }

}

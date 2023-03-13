package com.ecommerce.EcommerceApplication.controller;

import com.ecommerce.EcommerceApplication.model.Product;
import com.ecommerce.EcommerceApplication.payload.ApiResponse;
import com.ecommerce.EcommerceApplication.payload.CategoryDto;
import com.ecommerce.EcommerceApplication.payload.ProductDto;
import com.ecommerce.EcommerceApplication.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProductController
{

    @Autowired
    private ProductService productService;

    @PostMapping("/user/{userId}/category/{categoryId}/products")
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto,@PathVariable("userId") Integer userId,@PathVariable("categoryId") Integer categoryId)
    {
        ProductDto createProducts=this.productService.createProduct(productDto,userId,categoryId);
        return new ResponseEntity<ProductDto>(createProducts, HttpStatus.CREATED);
    }


    //get by user

    @GetMapping("/user/{userId}/products")
    public ResponseEntity<List<ProductDto>> getProductByUser(@PathVariable Integer userId)
    {
        List<ProductDto> productDtoList=this.productService.getProductByUser(userId);
        return new ResponseEntity<List<ProductDto>>(productDtoList,HttpStatus.OK);
    }

    //get by category

    @GetMapping("/category/{categoryId}/products")
    public ResponseEntity<List<ProductDto>> getProductByCategory(@PathVariable Integer categoryId)
    {
        List<ProductDto> productDtoList=this.productService.getProductByCategory(categoryId);
        return new ResponseEntity<List<ProductDto>>(productDtoList,HttpStatus.OK);
    }


//    @PutMapping("/{productId}")
//    public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto productDto,@PathVariable("productId") Integer productId)
//    {
//        ProductDto updateProductDto=this.productService.updateProduct(productDto,productId);
//        return ResponseEntity.ok(updateProductDto);
//
//    }
//
//    @DeleteMapping("/{productId}")
//    public ResponseEntity<ApiResponse> deleteUser(@PathVariable("productId") Integer productId)
//    {
//        this.productService.deleteProduct(productId);
//        return new ResponseEntity(new ApiResponse("Product Deleted Successfully",true),HttpStatus.OK);
//    }
//    @GetMapping("/{productId}")
//    public ResponseEntity<ProductDto> getProductById(@PathVariable("productId") Integer productId)
//    {
//        return ResponseEntity.ok(this.productService.getProductById(productId));
//
//    }
//
    @GetMapping("/products")

    public ResponseEntity<List<ProductDto>> getAllProducts()
    {
        List<ProductDto> productDtoList=this.productService.getAllProducts();
        return new ResponseEntity<List<ProductDto>>(productDtoList,HttpStatus.OK);
    }
}

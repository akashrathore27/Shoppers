package com.ecommerce.EcommerceApplication.controller;

import com.ecommerce.EcommerceApplication.payload.ApiResponse;
import com.ecommerce.EcommerceApplication.payload.CategoryDto;
import com.ecommerce.EcommerceApplication.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("")
    public ResponseEntity<CategoryDto> createCategory(@Valid  @RequestBody CategoryDto categoryDto)
    {
        CategoryDto createCategoryDto=this.categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(createCategoryDto, HttpStatus.CREATED);
    }

    @PutMapping("{categoryId}")
    public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto, @PathVariable("categoryId") Integer categoryId)
    {
        CategoryDto updateCategory=this.categoryService.updateCategory(categoryDto,categoryId);
        return new ResponseEntity<CategoryDto>(updateCategory, HttpStatus.OK);
    }

    @DeleteMapping("{categoryId}")
    public  ResponseEntity<ApiResponse> deleteCategory(@PathVariable("categoryId")Integer categoryId)
    {
        this.categoryService.deleteCategory(categoryId);
        return new ResponseEntity(new ApiResponse("Category Deleted Successfully",true),HttpStatus.OK);

    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable("categoryId") Integer categoryId)
    {
        CategoryDto categoryDto=this.categoryService.getCategoryById(categoryId);
        return  new ResponseEntity<CategoryDto>(categoryDto,HttpStatus.OK);

    }

    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getAllCategories()
    {
        List<CategoryDto> categoryDtoList=this.categoryService.getAllCategories();
        return ResponseEntity.ok(categoryDtoList);
    }

}

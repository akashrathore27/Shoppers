package com.ecommerce.EcommerceApplication.service;

import com.ecommerce.EcommerceApplication.payload.CategoryDto;

import java.util.List;

public interface CategoryService {

    //create category
    CategoryDto createCategory(CategoryDto categoryDto);

    //update category
    CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId);

    //delete category
    void deleteCategory(Integer categoryId);

    //get category by id
    CategoryDto getCategoryById(Integer categoryId);

    //get all categories
    List<CategoryDto> getAllCategories();

}

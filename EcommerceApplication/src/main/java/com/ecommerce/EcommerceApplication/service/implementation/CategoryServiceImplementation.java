package com.ecommerce.EcommerceApplication.service.implementation;

import com.ecommerce.EcommerceApplication.exception.ResourceNotFoundException;
import com.ecommerce.EcommerceApplication.model.Category;
import com.ecommerce.EcommerceApplication.payload.CategoryDto;
import com.ecommerce.EcommerceApplication.repository.CategoryRepository;
import com.ecommerce.EcommerceApplication.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImplementation implements CategoryService
{

    @Autowired
    private CategoryRepository categoryRepository;


    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto)
    {
        Category category=this.modelMapper.map(categoryDto,Category.class);
        Category saveCategory=this.categoryRepository.save(category);
        return this.modelMapper.map(saveCategory,CategoryDto.class);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
        Category category=this.categoryRepository.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("category","categoryId",categoryId));

        category.setCategoryName(categoryDto.getCategoryName());
        category.setCategoryDescription(categoryDto.getCategoryDescription());

        Category updateCategory=this.categoryRepository.save(category);

        return this.modelMapper.map(updateCategory,CategoryDto.class);
    }

    @Override
    public void deleteCategory(Integer categoryId)
    {
        Category category=categoryRepository.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("category","categoryId",categoryId));

        this.categoryRepository.delete(category);

    }

    @Override
    public CategoryDto getCategoryById(Integer categoryId)
    {
        Category category=categoryRepository.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("category","categoryId",categoryId));

        return this.modelMapper.map(category,CategoryDto.class);
    }

    @Override
    public List<CategoryDto> getAllCategories()
    {
        List<Category> categories=this.categoryRepository.findAll();
        List<CategoryDto> categoryDtoList= categories.stream().map(category->this.modelMapper.map(category,CategoryDto.class)).collect(Collectors.toList());

        return categoryDtoList;
    }
//
//    public Category dtoToCategory(CategoryDto categoryDto)
//    {
//        Category category=this.modelMapper.map(categoryDto,Category.class);
//        return category;
//    }
//    public CategoryDto categoryToDto(Category category)
//    {
//        CategoryDto categoryDto=this.modelMapper.map(category,CategoryDto.class);
//        return categoryDto;
//    }
}

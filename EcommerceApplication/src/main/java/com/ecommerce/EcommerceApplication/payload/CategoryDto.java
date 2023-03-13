package com.ecommerce.EcommerceApplication.payload;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class CategoryDto
{
    private int categoryId;
    @NotBlank
    @Size(min=5,message = "min size of category is 5")
    private String categoryName;
    @NotBlank
    private String categoryDescription;
}

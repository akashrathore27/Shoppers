package com.ecommerce.EcommerceApplication.payload;


import com.ecommerce.EcommerceApplication.model.Category;
import com.ecommerce.EcommerceApplication.model.User;
import lombok.Data;

import java.util.Date;

@Data
public class ProductDto
{
    private int productId;
    private String productName;
    private String productPrice;
    private String productBrand;

    private String description;
    private String productImage;
    private Date addedDate;

    private Category category;

    private User user;

}

package com.ecommerce.EcommerceApplication.repository;

import com.ecommerce.EcommerceApplication.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CategoryRepository extends JpaRepository<Category,Integer>
{

}

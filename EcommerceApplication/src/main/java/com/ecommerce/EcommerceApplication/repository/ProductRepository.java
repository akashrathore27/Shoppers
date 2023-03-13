package com.ecommerce.EcommerceApplication.repository;

import com.ecommerce.EcommerceApplication.model.Category;
import com.ecommerce.EcommerceApplication.model.Product;
import com.ecommerce.EcommerceApplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>
{

    List<Product> findByUser(User user);
    List<Product> findByCategory(Category category);


}

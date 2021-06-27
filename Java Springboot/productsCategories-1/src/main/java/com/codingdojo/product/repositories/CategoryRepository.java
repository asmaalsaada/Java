package com.codingdojo.product.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.product.models.Category;
import com.codingdojo.product.models.Product;

@Repository
public interface CategoryRepository extends CrudRepository<Category,Long>{
List<Category> findAll();
List<Category> findByProductsNotContains(Product product);
}

package com.codingdojo.product.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.product.models.Category;
import com.codingdojo.product.models.Product;

public interface ProductRepository extends CrudRepository<Product,Long>{
	List<Product> findAll();
	List<Product> findByCategoriesNotContains(Category category);

}

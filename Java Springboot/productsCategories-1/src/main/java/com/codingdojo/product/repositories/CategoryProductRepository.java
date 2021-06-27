package com.codingdojo.product.repositories;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.product.models.Category;
import com.codingdojo.product.models.CategoryProduct;

public interface CategoryProductRepository extends CrudRepository<CategoryProduct,Long>{

	void save(Category c);

}

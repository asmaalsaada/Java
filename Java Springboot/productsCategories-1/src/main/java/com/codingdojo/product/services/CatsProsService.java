package com.codingdojo.product.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.product.models.Category;
import com.codingdojo.product.models.CategoryProduct;
import com.codingdojo.product.models.Product;
import com.codingdojo.product.repositories.CategoryProductRepository;
import com.codingdojo.product.repositories.CategoryRepository;
import com.codingdojo.product.repositories.ProductRepository;

@Service
public class CatsProsService {
private final CategoryRepository categoryRepository;
private final ProductRepository productRepository;
private final CategoryProductRepository categoryProductRepository;



public CatsProsService(CategoryRepository categoryRepository, ProductRepository productRepository,
		CategoryProductRepository categoryProductRepository) {
	super();
	this.categoryRepository = categoryRepository;
	this.productRepository = productRepository;
	this.categoryProductRepository = categoryProductRepository;
}
public List<Category> allCats(){
	return categoryRepository.findAll();
}
public Category findCategory(Long id) {
	return categoryRepository.findById(id).orElse(null);
}
public Category createCategory(Category c) {
	return categoryRepository.save(c);
}
public List<Category> noRelatedId(Product p){
	return categoryRepository.findByProductsNotContains(p);
}
public void addProductToCategory(CategoryProduct categoryProduct) {
	categoryProductRepository.save(categoryProduct);
}
//productsService

public List<Product> allPros(){
	return productRepository.findAll();
}
public Product findProduct(Long id) {
	return productRepository.findById(id).orElse(null);
}
public Product createProduct(Product p) {
	return productRepository.save(p);
}
public List<Product> noRelatedIdCat(Category c){
	return productRepository.findByCategoriesNotContains(c);
}
//public void addCatToProduct(Product product, Category category) {
//	List<Category> categories = product.getCategories();
//	categories.add(category);
//	productRepository.save(product);
//}
//public void addProdToCat(Category category) {
//	productRepository.add
//}
public Category addCategory(Category c ) {
	return this.categoryRepository.save(c);
}
public Product addProduct(Product p) {
	return this.productRepository.save(p);
}
public CategoryProduct add(CategoryProduct cP) {
	return categoryProductRepository.save(cP);
}
}

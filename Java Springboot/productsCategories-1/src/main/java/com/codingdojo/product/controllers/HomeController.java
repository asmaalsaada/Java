package com.codingdojo.product.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.product.models.Category;
import com.codingdojo.product.models.CategoryProduct;
import com.codingdojo.product.models.Product;
import com.codingdojo.product.services.CatsProsService;

@Controller
public class HomeController {
private final CatsProsService catsProsService;
public HomeController(CatsProsService catsProsService) {
	super();
	this.catsProsService = catsProsService;
}
@RequestMapping("/products/new")
public String homePro(@ModelAttribute("Product") Product product) {
	return "index.jsp";
}
@PostMapping("/new/pro")
public String createPro(@ModelAttribute("Product") Product product,BindingResult result) {
	if(result.hasErrors()) {
		return "index.jsp";
	} else {
		catsProsService.createProduct(product);
		return "redirect:/products/"+product.getId();
	}
}
@RequestMapping("/categories/new")
public String homeCat(@ModelAttribute("Category")Category category) {
	return "newCat.jsp";
}
@PostMapping("/new/cat")
public String createCat(@ModelAttribute("Category")Category category,BindingResult result) {
	if (result.hasErrors()) {
		return "newCat.jsp";
	} else {
		catsProsService.createCategory(category);
		return "redirect:/categories/"+category.getId();
	}
}
@GetMapping("/products/{id}")
public String showPro(@PathVariable("id")Long id,@ModelAttribute("CategoryProduct") CategoryProduct categoryProduct,Model model) {
	Product product = catsProsService.findProduct(id);
	model.addAttribute("Product", product);
	List<Category> unAdded = catsProsService.noRelatedId(product);
	model.addAttribute("Categories", unAdded); //to show available Categories
	return "productPage.jsp";
}
@PostMapping("/pro/sero")
public String addProToCats(@Valid @ModelAttribute("CategoryProduct") CategoryProduct categoryProduct,BindingResult result) {
	if(result.hasErrors()) {
		return "productPage.jsp";
	}else {
		catsProsService.add(categoryProduct);
		return "redirect:/products/"+categoryProduct.getProduct().getId();
	}
}
@GetMapping("/categories/{id}")
public String showCat(@PathVariable("id")Long id,@ModelAttribute("CategoryProduct") CategoryProduct categoryProduct,Model model) {
	Category cat = catsProsService.findCategory(id);
	model.addAttribute("Category", cat);
	List<Product> unAdded = catsProsService.noRelatedIdCat(cat);
	model.addAttribute("Products", unAdded);
	return "categoryPage.jsp";
}
@PostMapping("/cat/sero")
public String addCatToPros(@Valid @ModelAttribute("CategoryProduct") CategoryProduct categoryProduct,BindingResult result) {
	if(result.hasErrors()) {
		return "categoryPage.jsp";
	} else {
		catsProsService.add(categoryProduct);
		return "redirect/categories/"+categoryProduct.getCategory().getId();
	}
	
}

}
package com.springexamportal.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springexamportal.model.exam.Category;
import com.springexamportal.service1.CategoryService;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {

	@Autowired
	private CategoryService cs;
	
	//add category
	@PostMapping("/")
	public ResponseEntity<Category> addCategiory(@RequestBody Category category){
		Category addCategory = this.cs.addCategory(category);
		return ResponseEntity.ok(addCategory);
	}
	
	//get category
	@GetMapping("/{id}")
	public ResponseEntity<Category> getCategory(@PathVariable("id")Long id) {
		return ResponseEntity.ok(this.cs.getCategory(id));
	}
	
	//get all categories
	@GetMapping("/")
	public ResponseEntity<Set<Category>> getAllCateories(){
	return ResponseEntity.ok(this.cs.getCategories());
}
	//update category
	@PutMapping("/")
	public Category updateCategory(@RequestBody Category category) {
		return this.cs.updateCategory(category);
	}
	
	//delete category
	@DeleteMapping("/{id}")
	public void deleteCategoryById(@PathVariable("id")Long id) {
		this.cs.deleteCategory(id);
	}
}
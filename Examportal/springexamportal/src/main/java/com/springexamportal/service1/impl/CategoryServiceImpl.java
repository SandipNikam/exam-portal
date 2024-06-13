package com.springexamportal.service1.impl;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springexamportal.model.exam.Category;
import com.springexamportal.repository.CategoryRepo;
import com.springexamportal.service1.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService{
@Autowired
	private CategoryRepo cr;
	
	@Override
	public Category addCategory(Category category) {
		return this.cr.save(category);
		
	}

	@Override
	public Category updateCategory(Category category) {
		return this.cr.save(category);
		
	}

//	@Override
//	public Set<Category> getCateories() {
//		return (Set<Category>) this.cr.findAll();
//		
//	}
	@Override
	public Set<Category> getCategories() {
	    List<Category> categoryList = (List<Category>) this.cr.findAll(); 
	    return new LinkedHashSet<>(categoryList);
	}

	@Override
	public Category getCategory(Long cid) {
		return this.cr.findById(cid).get();
		
	}

	@Override
	public void deleteCategory(Long catId) {
		Category c=new Category();
		c.setId(catId);
		this.cr.delete(c);
		
	}

}

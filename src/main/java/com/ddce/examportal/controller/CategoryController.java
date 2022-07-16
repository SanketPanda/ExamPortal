package com.ddce.examportal.controller;

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

import com.ddce.examportal.DTO.CategoryDTO;
import com.ddce.examportal.entity.exam.Category;
import com.ddce.examportal.service.CategoryService;


@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	/*
	 * add category
	*/
	@PostMapping("/add")
	private ResponseEntity<Category> createCategory(@RequestBody CategoryDTO categoryDTO){
		Category category = this.categoryService.addCategory(categoryDTO);
		return ResponseEntity.ok(category);
	}
	
	/*
	 * Get category based on id
	 */
	@GetMapping("/{categoryId}")
	private ResponseEntity<Category> getCategoryById(@PathVariable("categoryId") Long categoryId){
		return ResponseEntity.ok(this.categoryService.getCategory(categoryId));
	}
	
	/*
	 * Get all categories
	 */
	@GetMapping("/")
	private ResponseEntity<?> getCategories(){
		return ResponseEntity.ok(this.categoryService.getCategories());
	}
	
	/*
	 * Update category
	 */
	@PutMapping("/")
	private ResponseEntity<?> updateCategory(@RequestBody CategoryDTO categoryDTO){
		return ResponseEntity.ok(this.categoryService.updateCategory(categoryDTO));
	}
	
	/*
	 * Delete category based on id
	 */
	@DeleteMapping("/{categoryId}")
	private void deleteCategory(@PathVariable("categoryId") Long categoryId){
		this.categoryService.deleteCategory(categoryId);
	}
}

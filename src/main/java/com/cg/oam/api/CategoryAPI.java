package com.cg.oam.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.oam.exception.CategoryNotFoundException;
import com.cg.oam.model.CategoryModel;
import com.cg.oam.service.ICategoryService;

@RestController
@RequestMapping(path="/category")
public class CategoryAPI {
	@Autowired
	private ICategoryService catService;
	
	@GetMapping("/getallcategory")
	public ResponseEntity<List<CategoryModel>> findAll() {
		return new ResponseEntity<>(catService.findAll(), HttpStatus.OK); 
	}
	
	@GetMapping("/getcategory/{categoryId}")
	public ResponseEntity<CategoryModel> findById(@PathVariable("categoryId") String categoryId)throws CategoryNotFoundException {
		ResponseEntity<CategoryModel> response = null;
		System.out.println("find-by-catid");
		CategoryModel cat = catService.findById(categoryId);
		
		if (cat == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			response = new ResponseEntity<>(cat, HttpStatus.OK);
		}
		return response;
	}
	
	@PostMapping("/addcategory")
	public ResponseEntity<CategoryModel> createCategory(@RequestBody CategoryModel cat) throws CategoryNotFoundException {
		cat = catService.add(cat);
		return new ResponseEntity<>(cat, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deletecategory/{categoryId}")
	public ResponseEntity<Void> deleteCategory(@PathVariable("categoryId") String categoryId) {
		ResponseEntity<Void> response = null;
		CategoryModel cat = catService.findById(categoryId);
		if (cat == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			catService.deleteById(categoryId);
			response = new ResponseEntity<>(HttpStatus.OK);
		}
		return response;
	}
//	@PutMapping("/{categoryId}")
//	public ResponseEntity<CategoryModel> updateCategory(@RequestBody CategoryModel cat,@PathVariable("categoryId") String categoryId)throws CategoryNotFoundException {
//		cat = catService.modify(cat,cat.getCategoryId());
//		return new ResponseEntity<>(cat, HttpStatus.OK);
//	}
	@PutMapping("/updatecategory")  /*update by id */
	public ResponseEntity<CategoryModel> updateCategory(@RequestBody CategoryModel categorymodel) throws CategoryNotFoundException {
		categorymodel= catService.save(categorymodel);
		return new ResponseEntity<>(categorymodel, HttpStatus.OK);
	}
	
}

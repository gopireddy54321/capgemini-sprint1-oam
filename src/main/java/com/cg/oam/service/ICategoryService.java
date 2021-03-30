package com.cg.oam.service;

import java.util.List;

import com.cg.oam.exception.CategoryNotFoundException;
import com.cg.oam.model.CategoryModel;

public interface ICategoryService {
	
	CategoryModel add(CategoryModel categoryModel) throws CategoryNotFoundException;
	CategoryModel save(CategoryModel categoryModel) throws CategoryNotFoundException;
	void deleteById(String categoryId);
	CategoryModel findById(String categoryId);
	List<CategoryModel> findAll();

}

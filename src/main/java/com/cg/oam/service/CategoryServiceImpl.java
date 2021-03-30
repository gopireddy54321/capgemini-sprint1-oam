package com.cg.oam.service;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.oam.entity.Category;
import com.cg.oam.exception.CategoryNotFoundException;
import com.cg.oam.model.CategoryModel;
import com.cg.oam.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements ICategoryService{
	@Autowired
	private CategoryRepository catRepo;
	@Autowired
	private EMParser parser;
	
	public CategoryServiceImpl() {
		
	}
	
	public CategoryServiceImpl(CategoryRepository catRepo, EMParser parser) {
		super();
		this.catRepo = catRepo;
		this.parser = parser;
	}

	@Override
	public CategoryModel add(CategoryModel categoryModel) throws CategoryNotFoundException {
		if (categoryModel != null) {
			if (catRepo.existsById(categoryModel.getCategoryId())) {
				throw new CategoryNotFoundException("Customer with Id " + categoryModel.getCategoryId() + " is exist already");
			} 
			else {
				categoryModel = parser.parse(catRepo.save(parser.parse(categoryModel)));
			}
		}
		return categoryModel;
	}

	@Override
	public CategoryModel save(CategoryModel categoryModel) throws CategoryNotFoundException {
		Category oldcategory = catRepo.findById(categoryModel.getCategoryId()).orElse(null);
		if (oldcategory == null) {
			throw new CategoryNotFoundException("No Category with id " + categoryModel.getCategoryId() + " is present");
		}
		else {
			categoryModel = parser.parse(catRepo.save(parser.parse(categoryModel)));
		}
		return categoryModel;
	}

	@Override
	public void deleteById(String categoryId) {
		catRepo.deleteById(categoryId);
		
	}

	@Override
	public CategoryModel findById(String categoryId) {
		return parser.parse(catRepo.findById(categoryId).orElse(null));
	}

	@Override
	public List<CategoryModel> findAll() {
		
		return catRepo.findAll().stream().map(parser::parse).collect(Collectors.toList());
	}
	
	
	
}
package com.cg.oam.model;

public class CategoryModel {
	
	
	
	private String categoryId;
	private String categoryName;
	
	public CategoryModel() {
		
		
	}

	public CategoryModel(String categoryId, String categoryName) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	
	
}

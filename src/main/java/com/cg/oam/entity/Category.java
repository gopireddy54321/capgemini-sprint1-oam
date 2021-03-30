package com.cg.oam.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "categoryform")
public class Category implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="categoryid")
	private String categoryId;
	
	@Column(name="categoryname")
	@NotNull(message = "category name not be null")
	private String categoryName;
	
	
	public Category() {
		
	}
	public Category(String categoryId,String categoryName) {
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

package com.cg.oam.exception;

public class CategoryNotFoundException extends Exception{
private static final long serialVersionUID = 1L;
	
	public CategoryNotFoundException(String err) {
		super(err);
	}

}

package com.cg.oam.model;

import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;


public class MedicineModel {
	@NotNull(message="cannot be omitted")
	private String medicineId;
	
	@NotEmpty(message="cant be blank")
	@NotNull(message="cannot be omitted")
	private String medicineName;
	
	@NotEmpty(message="cant be blank")
	@NotNull(message="cannot be omitted")
	private float medicineCost;
	
	@PastOrPresent
	@NotEmpty(message="cant be blank")
	@NotNull(message="cannot be omitted")
	private LocalDate mfd;
	
	@Future
	@NotEmpty(message="cant be blank")
	@NotNull(message="cannot be omitted")
	private LocalDate expiryDate;
	
	private int quantity;
	
	private String categoryId;
	
	private String companyName;

	
	public MedicineModel() {
		
	}


	public MedicineModel(@NotNull(message = "cannot be omitted") String medicineId,
			@NotEmpty(message = "cant be blank") @NotNull(message = "cannot be omitted") String medicineName,
			@NotEmpty(message = "cant be blank") @NotNull(message = "cannot be omitted") float medicineCost,
			@PastOrPresent @NotEmpty(message = "cant be blank") @NotNull(message = "cannot be omitted") LocalDate mfd,
			@Future @NotEmpty(message = "cant be blank") @NotNull(message = "cannot be omitted") LocalDate expiryDate,
			int quantity, String categoryId, String companyName) {
		super();
		this.medicineId = medicineId;
		this.medicineName = medicineName;
		this.medicineCost = medicineCost;
		this.mfd = mfd;
		this.expiryDate = expiryDate;
		this.quantity = quantity;
		this.categoryId = categoryId;
		this.companyName = companyName;
	}


	public String getMedicineId() {
		return medicineId;
	}


	public void setMedicineId(String medicineId) {
		this.medicineId = medicineId;
	}


	public String getMedicineName() {
		return medicineName;
	}


	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}


	public float getMedicineCost() {
		return medicineCost;
	}


	public void setMedicineCost(float medicineCost) {
		this.medicineCost = medicineCost;
	}


	public LocalDate getMfd() {
		return mfd;
	}


	public void setMfd(LocalDate mfd) {
		this.mfd = mfd;
	}


	public LocalDate getExpiryDate() {
		return expiryDate;
	}


	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public String getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}


	public String getCompanyName() {
		return companyName;
	}


	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	
	
	
}

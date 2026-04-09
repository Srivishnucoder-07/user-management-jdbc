package com.project.model;


public class Order {
    private int id;
    private int userId;
    private String ProductName;
    private double Amount;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public double getAmount() {
		return Amount;
	}
	public void setAmount(double amount) {
		Amount = amount;
	}
	public Order() {
		super();
		this.id = id;
		this.userId = userId;
		this.ProductName = ProductName;
		this.Amount = Amount;
	}
	
	
	
	
    
	

    
}
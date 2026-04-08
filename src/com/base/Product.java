package com.base;

import com.business_layer.Product_Business;

public class Product {
	
	private String productId;
	private String productType;
	private String productBrand;
	private double productPrice;
	private int productQuantity;
	
	public Product(String productType, String productBrand, double productPrice, int productQuantity, String productId) {
		this.productType = productType;
		this.productBrand = productBrand;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
		this.productId = productId;
	}
	
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductType() {
		return productType;
	}

	public String getProductBrand() {
		return productBrand;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public String getProductId() {
		return productId;
	}

	@Override
	public String toString() {
	    return Product_Business.BG_BLACK+"--------------------------------------------------------------------------------------------\n"+Product_Business.RESET +
	    		String.format(Product_Business.BG_BLACK+Product_Business.BOLD+"| %-15s | %-15s | %-15s | %-15s | %-5s |%n"+Product_Business.RESET,"Product ID", "Product Type", "Product Brand", "Product Price", "Product Quantity") +
	    		Product_Business.BG_BLACK+"--------------------------------------------------------------------------------------------\n"+Product_Business.RESET  +
	           String.format(Product_Business.BG_BLACK+Product_Business.CYAN+"| %-15s | %-15s | %-15s | %-15.2f | %-16d |\n"+Product_Business.RESET,
	           productId, productType, productBrand, productPrice, productQuantity) +
	           Product_Business.BG_BLACK+"--------------------------------------------------------------------------------------------"+Product_Business.RESET;
	}
		
}
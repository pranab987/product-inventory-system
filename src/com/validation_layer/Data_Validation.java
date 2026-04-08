package com.validation_layer;

import java.util.Random;

public class Data_Validation {
	public static boolean validateMobileNumber(long mobileNumber) {
		String st = mobileNumber + "";
		char ch = st.charAt(0);
		
		if ((ch == '6' || ch == '7' || ch == '8' || ch == '9') && st.length() == 10)
			return true;
		
		return false;
	}
	public static String generateProductId(String productType, String productBrand) {
		Random r = new Random();
		String productId = "";
	    String typePart = productType.length() >= 3
	            ? productType.substring(0, 3)
	            : productType;
	    int number = r.nextInt(900) + 100;
	    String brandPart = productBrand.length() >= 3
	            ? productBrand.substring(productBrand.length() - 3)
	            : productBrand;
	    productId = typePart + number + brandPart;
	    return productId.toUpperCase();
	}
}
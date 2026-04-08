package com.service_layer;

import java.util.Scanner;

import com.business_layer.Product_Business;
import com.validation_layer.Data_Validation;

public class ProductMain {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) throws InterruptedException {
		
//		System.out.println("\u001B[31m" + "\u001B[43m" + "Welcome to my project");
		Product_Business.animateString("Welcome to JSP - Product Inventory System");
		System.out.println();
//		System.out.println("Welcome to JSP - Product Inventory System");

		if (login()) {
			runMenu();
		} else {
			System.out.println("Invalid Mobile Number");
		}
		sc.close();
	}
	public static boolean login() {
		System.out.println("Login to the Inventory");
		System.out.print("Enter your Mobile Number: ");
		long mobileNumber = sc.nextLong();
		if (!Data_Validation.validateMobileNumber(mobileNumber)) {
			System.out.println("Invalid Mobile Number");
			return false;
		}
		int genOTP = Product_Business.generateOTP();
		System.out.println("Your OTP :- "+genOTP);
		System.out.print("Enter the OTP: ");
		int enOTP = sc.nextInt();
		if (enOTP == genOTP) {
			System.out.println("Login Successfull");
			return true;
		} else {
			System.out.println("Invalid OTP. \nTry Again after Sometime");
			return false;
		}
	}
	
	public static void runMenu() {
		int choice;
		do {
			showMenu();
			choice = sc.nextInt();
			handleChoice(choice);
		} while(choice != 6);
	}
	
	public static void showMenu() {
		System.out.println("\n===== MENU =====");
		System.out.println("1. Add Product");
		System.out.println("2. Remove Product");
		System.out.println("3. View All Products");
		System.out.println("4. Search a Product");
		System.out.println("5. Update Product Price");
		System.out.println("6. Exit");
		System.out.print("Enter your choice: ");
	}
	
	public static void handleChoice(int choice) {
		switch (choice) {
		case 1:
			Product_Business.addProduct();
			break;

		case 2:
			Product_Business.removeProduct();
			break;

		case 3:
			Product_Business.viewAllTheProducts();
			break;
			
		case 4:
			Product_Business.searchAProducts();
			break;

		case 5:
			Product_Business.updateProductPrice();
			break;

		case 6:
			System.out.println("Exiting program...Thank You");
			System.exit(0);

		default:
			System.out.println("Invalid choice! Please try again.");
		}
	}
}
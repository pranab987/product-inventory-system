package com.business_layer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

import com.base.Product;
import com.validation_layer.Data_Validation;

public class Product_Business {

	private static ArrayList<Product> productList = new ArrayList<Product>();
	static Scanner sc = new Scanner(System.in);

	public static String RESET = "\u001B[0m";
	public static String RED = "\u001B[91m";
	public static String GREEN = "\u001B[92m";
	public static String YELLOW = "\u001B[93m";
	public static String BLUE = "\u001B[94m";
	public static String CYAN = "\u001B[96m";
	public static String BOLD = "\u001B[1m";
	public static String BG_BLACK = "\u001B[40m";

	public static int generateOTP() {
		Random r = new Random();
		return r.nextInt(99999);
	}

	public static void addProduct() {
		System.out.print(YELLOW + "Enter Product Type: " + RESET);
		String productType = sc.next();

		System.out.print(YELLOW + "Enter Product Brand: " + RESET);
		String productBrand = sc.next();

		System.out.print(YELLOW + "Enter Product Price: " + RESET);
		double productPrice = sc.nextDouble();

		System.out.print(YELLOW + "Enter Product Quantity: " + RESET);
		int productQuantity = sc.nextInt();

		String productId = Data_Validation.generateProductId(productType, productBrand);
		Product p = new Product(productType, productBrand, productPrice, productQuantity, productId);

		productList.add(p);

		System.out.println(GREEN + "Product Added Successfully" + RESET);
		System.out.println(p);
	}

	public static void updateProductPrice() {

		if (!productList.isEmpty()) {

			System.out.print(YELLOW + "Enter Product Id: " + RESET);
			String productId = sc.next();

			boolean found = false;

			for (Product p : productList) {
				if (p.getProductId().equalsIgnoreCase(productId)) {

					System.out.print(YELLOW + "Enter Product Price: " + RESET);
					double updatedPrice = sc.nextDouble();

					p.setProductPrice(updatedPrice);

					System.out.println(GREEN + "Product Price Updated successfully" + RESET);
					System.out.println(p);

					found = true;
					break;
				}
			}

			if (!found) {
				System.out.println(RED + "Invalid Product ID" + RESET);
			}

		} else {
			System.out.println(RED + "No Product Added.. Add a Product" + RESET);
		}
	}

	public static void viewAllTheProducts() {

		if (!productList.isEmpty()) {

			System.out.println(BLUE + BOLD + "\n===== PRODUCT LIST =====" + RESET);
			
			System.out.println(BG_BLACK+"--------------------------------------------------------------------------------------------"+RESET);
			System.out.printf(BG_BLACK+BOLD+"| %-15s | %-15s | %-15s | %-15s | %-5s |%n"+RESET,"Product ID", "Product Type", "Product Brand", "Product Price", "Product Quantity");
			System.out.println(BG_BLACK+"--------------------------------------------------------------------------------------------"+RESET);
			for (Product p : productList) {
				System.out.printf(BG_BLACK+CYAN+"| %-15s | %-15s | %-15s | %-15.2f | %-16d |%n"+ RESET,p.getProductId(),p.getProductType(),p.getProductBrand(),p.getProductPrice(),p.getProductQuantity());
				System.out.println(BG_BLACK+"--------------------------------------------------------------------------------------------"+RESET);
			}

		} else {
			System.out.println(RED + "No Product Added.. Add a Product" + RESET);
		}
	}

	public static void removeProduct() {

		if (!productList.isEmpty()) {

			System.out.print(YELLOW + "Enter Product Id to Remove: " + RESET);
			String removeId = sc.next();

			Iterator<Product> it = productList.iterator();
			boolean found = false;

			while (it.hasNext()) {
				Product p = it.next();

				if (p.getProductId().equalsIgnoreCase(removeId)) {
					it.remove();

					System.out.println(GREEN + "Product removed successfully" + RESET);
					System.out.println(p);

					found = true;
					break;
				}
			}

			if (!found) {
				System.out.println(RED + "Invalid Product ID" + RESET);
			}

		} else {
			System.out.println(RED + "No Product Added.. Add a Product" + RESET);
		}
	}

	public static void searchAProducts() {

		if (!productList.isEmpty()) {

			System.out.print(YELLOW + "Enter Product Id to Search: " + RESET);
			String searchId = sc.next();

			boolean found = false;

			for (Product p : productList) {
				if (p.getProductId().equalsIgnoreCase(searchId)) {
					System.out.println(p);
					found = true;
					break;
				}
			}

			if (!found) {
				System.out.println(RED + "Invalid Product ID" + RESET);
			}

		} else {
			System.out.println(RED + "No Product Added.. Add a Product" + RESET);
		}
	}

	public static void animateString(String st) throws InterruptedException {
		for (int i = 0; i < st.length(); i++) {
			System.out.print(BG_BLACK + CYAN + BOLD + st.charAt(i) + RESET);
			Thread.sleep(40);
		}
		System.out.println();
	}
}
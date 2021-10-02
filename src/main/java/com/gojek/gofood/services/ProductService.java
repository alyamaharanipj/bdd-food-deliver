package com.gojek.gofood.services;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.gojek.gofood.model.*;
import com.google.common.base.Stopwatch;

import java.util.logging.Level; 
import java.util.logging.Logger; 


public class ProductService {
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME); 
	private List<Product> productsList;	
	private class DistanceComparator implements Comparator<Product>{
		public int compare(Product product1, Product product2) {
			return ((Float) (product1.getDistance())).compareTo( (Float)product2.getDistance());
		}
	}
	
	private class RateComparator implements Comparator<Product>{
		public int compare(Product product1, Product product2) {
			return ((Float) (product1.getRating())).compareTo( (Float)product2.getRating());
		}
	}
	
	private class CategoryComparator implements Comparator<Product>{
		public int compare(Product product1, Product product2) {
			return((String) (product1.getCategory())).compareTo( (String)product2.getCategory());
		}
	}
	
	public ProductService(List<Product> pl) {
		productsList = pl;
	}	
	
	public List<String> getDiscountedProductsName() {
		LOGGER.log(Level.INFO, "Running " + (new Throwable()).getStackTrace()[0].getMethodName() + "()");
		Stopwatch stopwatch = Stopwatch.createStarted();
		ArrayList<String> result = new ArrayList<String>();
		for(Product e : productsList) {
			if(e.getDiscount() > 0)
				result.add(e.getName());
		}
		stopwatch.stop();
		LOGGER.log(Level.INFO, "Found " + result.size() +" items in " + stopwatch.elapsed(TimeUnit.NANOSECONDS) + " nanoseconds");
		return result;
	}
	
	public List<String> getProductsNameOrderByDistanceAsc(){
		LOGGER.log(Level.INFO, "Running " + (new Throwable()).getStackTrace()[0].getMethodName() + "()");
		Stopwatch stopwatch = Stopwatch.createStarted();
		ArrayList<String> result = new ArrayList<String>();
		Collections.sort(productsList, new DistanceComparator());
		for(Product e : productsList) {
			if (e.getDistance() <= 20)
			result.add(e.getName());
		}	
		stopwatch.stop();
		LOGGER.log(Level.INFO, "Found " + result.size() +" items in " + stopwatch.elapsed(TimeUnit.NANOSECONDS) + " nanoseconds");
		return result;
	}
	
	public List<String> getProductsNameOrderByRate(){
		LOGGER.log(Level.INFO, "Running " + (new Throwable()).getStackTrace()[0].getMethodName() + "()");
		Stopwatch stopwatch = Stopwatch.createStarted();
		ArrayList<String> result = new ArrayList<String>();
		Collections.sort(productsList, Collections.reverseOrder(new RateComparator()));
		for(Product e : productsList) {
			result.add(e.getName());
		}		
		stopwatch.stop();
		LOGGER.log(Level.INFO, "Found " + result.size() +" items in " + stopwatch.elapsed(TimeUnit.NANOSECONDS) + " nanoseconds");
		return result;
	}
	

	public Product find(String productName) {
		LOGGER.log(Level.INFO, "Running " + (new Throwable()).getStackTrace()[0].getMethodName() + "(\"" + productName +"\")");
		Stopwatch stopwatch = Stopwatch.createStarted();

		for(Product p : productsList) {
			if(p.getName().equals(productName)) {
				stopwatch.stop();
				LOGGER.log(Level.INFO, "Found product "+ p.getName() +" in " + stopwatch.elapsed(TimeUnit.NANOSECONDS) + " nanoseconds");
				return p;
			}
		}
		stopwatch.stop();
		LOGGER.log(Level.INFO, "Product not found in " + stopwatch.elapsed(TimeUnit.NANOSECONDS) + " nanoseconds");
		return null;
	}

	public List<String> getCategoryTypeOfProducts() {
		LOGGER.log(Level.INFO, "Running " + (new Throwable()).getStackTrace()[0].getMethodName() + "()");
		Stopwatch stopwatch = Stopwatch.createStarted();
		
		ArrayList<String> result = new ArrayList<String>();
		Collections.sort(productsList, Collections.reverseOrder(new CategoryComparator()));
		for(Product e : productsList) {
			result.add(e.getName());
		}
		stopwatch.stop();
		LOGGER.log(Level.INFO, "Finished in " + stopwatch.elapsed(TimeUnit.NANOSECONDS) + " nanoseconds");
		return result;
	}
	
	public Merchant findMerchant(String merchantName) {
		LOGGER.log(Level.INFO, "Running " + (new Throwable()).getStackTrace()[0].getMethodName() + "(\"" + merchantName + "\")");
		Stopwatch stopwatch = Stopwatch.createStarted();
		
		for(Product p : productsList) {
			if(p.getMerchant() != null) {
				if(p.getMerchant().getName().equals(merchantName)) {
					stopwatch.stop();
					LOGGER.log(Level.INFO, "Found merchant "+ p.getMerchant().getName() +" in " + stopwatch.elapsed(TimeUnit.NANOSECONDS) + " nanoseconds");
					return p.getMerchant();							
				}
			}
		}
		LOGGER.log(Level.INFO, "Product not found in " + stopwatch.elapsed(TimeUnit.NANOSECONDS) + " nanoseconds");
		return null;
	}
	
	public List<String> getBestProduct() {
		ArrayList<String> result= new ArrayList<String>() ;
		String name ="";
		float score;
		float comparator=50;
		for (Product e : productsList) {
			score = e.getDistance()-e.getRating();
			if (comparator>score) {
				comparator = score;
				name = e.getName();
			}
		}
		result.add(name);
		return result;
	}
}

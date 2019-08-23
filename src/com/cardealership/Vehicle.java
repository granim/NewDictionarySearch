package com.cardealership;

public class Vehicle {

	private String make;
	private String model;
	private int year;
	private double miles;
	private String color;
	private double price;
	
	public Vehicle(String make, String model, int year, double miles, String color, double price) {
		super();
		this.make = make;
		this.model = model;
		this.year = year;
		this.miles = miles;
		this.color = color;
		this.price = price;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getMiles() {
		return miles;
	}

	public void setMiles(double miles) {
		this.miles = miles;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
}

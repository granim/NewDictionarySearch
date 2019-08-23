package com.cardealership;

public class Customer {
	private String name;
	private String address;
	private double cashOnHand;
	private int credit;

	int getCredit() {
		return credit;
	}

	void setCredit(int credit) {
		this.credit = credit;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
	//	address += " Dealership City";
		this.address = address;
	}

	public double getCashOnHand() {
		return cashOnHand;
	}

	public void setCashOnHand(double cashOnHand) {
		
		this.cashOnHand = cashOnHand;
	}

	public void purchaseCar(Vehicle vehicle, Employee emp, boolean finance) {
		emp.handleCustomer(this, finance, vehicle);
	}
	
}

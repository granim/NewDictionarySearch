package com.cardealership;

public class Employee {

	private int id;
	private String name;
	private double commission;
	private double newAmount;

	public Employee(int id, String name, double commission) {
		super();
		this.id = id;
		this.name = name;
		this.commission = commission;
	}

	public void loan(Customer cust, double cashOnHand) {
		newAmount = cust.getCashOnHand();
		newAmount += 500;
		System.out.println("Your new cash on hand amount is " + newAmount);
		this.newAmount = newAmount;
	}

	public void checkCredit(Customer cust) {
		if (cust.getCredit() <= 650) {
			System.out.println("Sorry your credit score is too low");
		} else {
			System.out.println("You have been aproved for credit");
			loan(cust, cust.getCashOnHand());
		}
	}

	public void handleCustomer(Customer cust, boolean finance, Vehicle vehicle) {
		System.out.println("Hello " + cust.getName() + " your current chash on hand is " + cust.getCashOnHand());

		if (cust.getCashOnHand() > vehicle.getPrice()) {
			System.out.println("You have enough cash on hand.");
		} else {
			if (finance == false) {
				System.out.println("You do not need to finance the " + vehicle.getMake());
			} else {
				System.out.println("We need to check your credit.");
				checkCredit(cust);
			}
		}

		if (newAmount > vehicle.getPrice()) {
			System.out.println("Congratulations you can afford this new car! " + vehicle.getMake());
		} else {
			System.out.println(newAmount);
			System.out.println("I am sorry you cannot afford this vehicle.");
		}

	}

	public void commision(Customer cus, Vehicle vehicle, Employee employee) {
		System.out.println(employee.getName() + " Your commission is ");
		double amountOne = vehicle.getPrice();
		double amountTwo = employee.getCommission();
		System.out.println(amountOne / amountTwo + " Dollars.");
	}

	private double getCommission() {
		return commission;
	}

	private String getName() {
		return name;
	}

}

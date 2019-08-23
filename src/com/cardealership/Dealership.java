package com.cardealership;

public class Dealership {

	public static void main(String[] args) {
		//Write a program to simulate a car dealership sales process. We'll have EMPLOYEES, working selling VEHICLES to CUSTOMERS.
			//Think about nouns person, place, thing
		//Employees, cars, customers, and the dealership
			
		Customer cust1 = new Customer();
		cust1.setName("Tim");
		cust1.setAddress("123 This St. ");
		cust1.setCashOnHand(300);
		cust1.setCredit(700);
		Vehicle vehicleOne = new Vehicle("ford", "f-150", 2016, 8, "blue", 700);
		Vehicle vehicleTwo = new Vehicle("Chevy", "Sivlerado", 2015, 6, "Grey", 16500);
		Employee empOne = new Employee(20, "John", 4.5);
		
		
		
		
		empOne.handleCustomer(cust1, true, vehicleOne);
		empOne.commision(cust1, vehicleOne, empOne);
	}

}

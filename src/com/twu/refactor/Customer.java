package com.twu.refactor;

import java.beans.Statement;
import java.util.ArrayList;
import java.util.Iterator;

public class Customer {

	private String name;
	private ArrayList<Rental> rentalList = new ArrayList<Rental>();

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental arg) {
		rentalList.add(arg);
	}

	public String getName() {
		return name;
	}


	public String statement() {
		return  new CustomerStatement(getName(),rentalList).toString();
	}

    public String htmlStatement() {
        return  new CustomerStatement(getName(),rentalList).asHTML();
    }
}

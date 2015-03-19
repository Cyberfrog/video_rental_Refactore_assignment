package com.twu.refactor;

import java.beans.Statement;
import java.util.*;

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
        String result = "Rental Record for "+name+"\n";
        for(String title:getAllMovieRent().keySet()){
            result += "\t" + title + "\t"
                    + String.valueOf(getAllMovieRent().get(title)) + "\n";
        }
        result += "Amount owed is " + String.valueOf(getTotalAmount()) + "\n";
        result += "You earned " + String.valueOf(getFrequentPoints())
                + " frequent renter points";
        return result;

    }

    private double getTotalAmount(){
        double totalRent =0;
        for(Rental rental:rentalList){
            totalRent +=rental.getAmount();
        }
        return totalRent;
    }

    private  Map<String,Double> getAllMovieRent(){
        Map<String,Double> allMoviesRent =new LinkedHashMap<String, Double>();
        for(Rental rental:rentalList) {
            allMoviesRent.put(rental.getMovie().getTitle(),rental.getAmount());
        }
            return allMoviesRent;

    }
    private int getFrequentPoints(){
        int frequentRenterPoints=0;
        for(Rental rental:rentalList) {
            frequentRenterPoints += rental.getFrequentPoints();
        }
        return  frequentRenterPoints;
    }

    public String htmlStatement() {
        String result = "<H1>Rentals for <EM>" +name + "</EM></H1><P>";
        for(String title:getAllMovieRent().keySet()){
            result +=  title + ": "
                    + String.valueOf(getAllMovieRent().get(title)) + "<BR>";
        }
        result += "<P>You owe <EM>" + String.valueOf(getTotalAmount()) + "</EM>";
        result += "<P>On this rental you earned <EM>" + String.valueOf(getFrequentPoints())
                + "</EM> frequent renter points<P>\n";
        return  result;
    }

}

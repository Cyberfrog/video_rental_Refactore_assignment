package com.twu.refactor;

import java.util.*;

/**
 * Created by gauravd on 3/17/2015.
 */
public class CustomerStatement {
    private final String customerName;
    private double totalAmount ;
    private int frequentRenterPoints;
    private Map<String,Double> figures;

    public CustomerStatement(String name, List<Rental> rentalList) {
        figures =new LinkedHashMap<String, Double>();
        this.customerName = name;
        for(Rental each:rentalList){
            double thisAmount= each.getAmount();
            figures.put(each.getMovie().getTitle(),thisAmount);
            this.totalAmount +=thisAmount;
            this.frequentRenterPoints += each.getFrequentPoints();
        }
    }

    @Override
    public  String toString(){
        String result = "Rental Record for "+customerName+"\n";
        Set<String> allMovieTitles =figures.keySet();
        for(String title:allMovieTitles){
            result += "\t" + title + "\t"
                    + String.valueOf(figures.get(title)) + "\n";
        }
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints)
                + " frequent renter points";
        return result;
    }

    public  String asHTML(){
        String result = "<H1>Rentals for <EM>" +customerName + "</EM></H1><P>";
        Set<String> allMovieTitles =figures.keySet();
        for(String title:allMovieTitles){
            result +=  title + ": "
                    + String.valueOf(figures.get(title)) + "<BR>";
        }
        result += "<P>You owe <EM>" + String.valueOf(totalAmount) + "</EM>";
        result += "<P>On this rental you earned <EM>" + String.valueOf(frequentRenterPoints)
                + "</EM> frequent renter points<P>\n";
        return  result;
    }
}

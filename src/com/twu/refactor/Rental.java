package com.twu.refactor;

public class Rental {

    private Movie movie;

    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }
    public double getAmount(){
        return movie.getPriceCode().getCostFor(daysRented);
    }

    public int getFrequentPoints() {
        int frequentRenterPoints =1;
        // add bonus for a two day new release rental
        if ((getMovie().getPriceCode() == MoviePricingCategory.NEW_RELEASE)
                && getDaysRented() > 1)
            frequentRenterPoints++;
        return frequentRenterPoints;
    }
}
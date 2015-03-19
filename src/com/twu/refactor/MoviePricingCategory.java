package com.twu.refactor;

/**
 * Created by gauravd on 3/17/2015.
 */
public enum MoviePricingCategory {
     CHILDREN(1.5,1.5,3),
      REGULAR(2,1.5,2),
      NEW_RELEASE(0,3,0);
    private double upFrontCost;
    private double perDayCost;
    private double upForntCostValidity;

    MoviePricingCategory(double upFrontCost,double perDayCost,double upForntCostValidity){

        this.upFrontCost = upFrontCost;
        this.perDayCost = perDayCost;
        this.upForntCostValidity = upForntCostValidity;
    }

    public double getCostFor(int daysRented) {
        double thisAmount = upFrontCost;
        if (daysRented > upForntCostValidity)
            thisAmount += (daysRented - upForntCostValidity) * perDayCost;
        return thisAmount;
    }
}

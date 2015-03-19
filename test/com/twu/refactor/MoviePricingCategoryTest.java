package com.twu.refactor;

import org.junit.Test;

import static org.junit.Assert.*;

public class MoviePricingCategoryTest {
    @Test
    public void test_CHILDRENS_category_gives_CorrectCost_for_four_days_rented() {
       double cost =  MoviePricingCategory.CHILDREN.getCostFor(4);
        assertEquals(3.0,cost,0.0);
    }

    @Test
    public void test_CHILDRENS_category_gives_CorrectCost_for_lessThan_3_days_rented() {
       double oneDaycost =  MoviePricingCategory.CHILDREN.getCostFor(1);
       double twoDaycost =  MoviePricingCategory.CHILDREN.getCostFor(2);
        assertEquals(1.5,oneDaycost, 0.0);
        assertEquals(1.5, twoDaycost, 0.0);
    }

    @Test
    public void test_REGULAR_category_gives_CorrectCost_for_lessThan_2_days_rented() {
        double oneDaycost =  MoviePricingCategory.REGULAR.getCostFor(1);
        assertEquals(2,oneDaycost, 0.0);
    }
    @Test
    public void test_NewRelease_category_gives_CorrectCost_for_3_days_rented() {
        double threeDaycost =  MoviePricingCategory.NEW_RELEASE.getCostFor(3);
        assertEquals(9,threeDaycost, 0.0);
    }

}
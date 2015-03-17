package com.twu.refactor;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by gauravd on 3/17/2015.
 */
public class RentalTest {
    @Test
    public void test_Rental_gives_amount_toBePaid() {
        Movie run = new Movie("run",Movie.REGULAR);
        Rental r =new Rental( run,2);
        assertEquals(4.0,r.getAmount(),0.0);

    }
}

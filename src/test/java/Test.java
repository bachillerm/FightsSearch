package test.java;

import main.java.bo.Flight;
import main.java.support.PricingCalculations;
import junit.framework.TestCase;
import main.java.enums.Airport;

public class Test extends TestCase{
	
	
	/**
	 * Test that checks that if we introduce negative number of days until the flight we get a 0 discount.
	 */
	public void testCalculateDiscountMethod(){
		assertTrue("Get 0% discount for negative number of days.", PricingCalculations.calculateDiscount(-2) == 0);
	}
	
	/**
	 * Test to check that the total price would be zero when the discount is zero.
	 */
	public void testCalculateTotalPriceWithZeroDiscount(){
		Flight flight1 = new Flight(Airport.MADRID,Airport.AMSTERDAM,"IB9961",120);
		assertTrue("Total price zero", PricingCalculations.calculateTotalPrice(2, 3, 0, 0, flight1) == 0);
	}
	
	/**
	 * Test that checks that the total price is zero when there is a non existent airline.
	 */
	public void testCalculateTotalPriceWithNoAirline(){
		Flight flight2 = new Flight(Airport.MADRID,Airport.AMSTERDAM,"XX1234",120);
		assertTrue("Total price zero", PricingCalculations.calculateTotalPrice(2, 3, 0, 4, flight2) == 0);
	}
}

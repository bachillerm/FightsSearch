package main.java.support;

import main.java.bo.Flight;

/**
 * Support Class that has all the calculation methods in order to get the total price of a flight.
 * @author martabachiller
 *
 */
public class PricingCalculations {
	
	/*### Passenger type
	| passenger type | price                                                                                          |
	|----------------|------------------------------------------------------------------------------------------------|
	| adult          | full price (i.e. price resulting from the *days to departure date* rule)                       |
	| child          | 33% discount of the price calculated according to the *days to departure date* rule            |
	| infant         | fixed price depending on the airline. Rule *days to departure date* is not applied for infants |
	 */
	
	public static float calculateTotalPrice(Integer numberAdults, Integer numberchildren, Integer numberInfant, Integer discount, Flight flight) {
		float adultPrice = flight.getBasePrice()*discount/100;
        float childPrice =  (flight.getBasePrice()*discount/100)*67/100;
        if(flight.getAirline() == null) {
        	System.out.println("ERROR: Airline not found calculating the total price for airline code " + flight.getAirlineCode());
        	return 0;	
        } 
        float infantPrice  = flight.getAirline().getInfantPrice();
        return (adultPrice*numberAdults)+(childPrice*numberchildren)+(infantPrice*numberInfant);       
    }

	/*
	### Days to departure date
	| days prior to the departure date | % of the base price |
	|----------------------------------|---------------------|
	| more than 30 (i.e. >= 31)        | 80%                 |
	| 30 - 16                          | 100%                |
	| 15 - 3                           | 120%                |
	| less that 3 (i.e. <= 2)          | 150%                |
	*/
    public static Integer calculateDiscount(Integer numberDaysTillFlight) {
        if (numberDaysTillFlight > 30 ) {
            return 80;
        } else if (numberDaysTillFlight <= 30 && numberDaysTillFlight >= 16 ) {
            return 100;
        } else if (numberDaysTillFlight <= 15 && numberDaysTillFlight >= 3) {
            return 120;
        } else if(numberDaysTillFlight >= 0){
            return 150;
        } else {
        	return 0;
        }
    }
}

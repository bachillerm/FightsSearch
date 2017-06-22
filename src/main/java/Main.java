package main.java;

import java.text.DecimalFormat;
import java.util.Set;

import main.java.bo.Flight;
import main.java.support.CSVReader;
import main.java.support.PricingCalculations;

public class Main {
	 public static void main(String[] args) {
		String origin = args[0];
        String destination = args[1];
        Integer numberAdults = Integer.valueOf(args[2]);
        Integer numberchildren = Integer.valueOf(args[3]);
        Integer numberInfant = Integer.valueOf(args[4]);
        Integer numberDaysTillFly = Integer.valueOf(args[5]);

        boolean flightFound = Boolean.FALSE; // flag that it is going to store if there are flights for the origin and destination entered
        Integer discount = PricingCalculations.calculateDiscount(numberDaysTillFly);
        Set<Flight> flights = CSVReader.getFlights();
        
        for (Flight flight : flights) {
            if (flight.getOrigin().getCode().equals(origin) && flight.getDestination().getCode().equals(destination)) {
                Float totalPrice = PricingCalculations.calculateTotalPrice(numberAdults, numberchildren, numberInfant, discount, flight);
                System.out.print("Origin --> " + flight.getOrigin()+"; ");
                System.out.print("Destination  --> " + flight.getDestination()+"; ");
                System.out.print("Airlinecode --> " + flight.getAirlineCode()+"; ");
                DecimalFormat df = new DecimalFormat();
                df.setMaximumFractionDigits(2);
                System.out.println("Total Price : " + df.format(totalPrice));
                flightFound = Boolean.TRUE;
            }
        }
        
        if(!flightFound){
        	System.out.println("No flights available");
        }
	 }
}

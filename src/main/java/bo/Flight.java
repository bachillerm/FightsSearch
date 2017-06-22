package main.java.bo;

import main.java.enums.Airline;
import main.java.enums.Airport;
import main.java.utils.EnumUtils;

/**
 * Class that stores all the flight«s information
 * @author martabachiller
 *
 */
public class Flight {

	private Airport origin;
	private Airport destination;
	private String airlineCode;
	private Airline airline;
	private float basePrice = 0;
	
	public Flight(Airport origin,Airport destination,String airlineCode,float basePrice){
		setOrigin(origin);
		setDestination(destination);
		setAirlineCode(airlineCode);
		Airline airline = (Airline) EnumUtils.search(Airline.class, airlineCode.substring(0,2));
		if(airline == null) {
			System.out.println("Airline not found creating the flight.");		
		} else {
			setAirline(airline);
		}
		setBasePrice(basePrice);
	}

	public Airport getOrigin() {
		return origin;
	}


	public void setOrigin(Airport origin) {
		this.origin = origin;
	}


	public Airport getDestination() {
		return destination;
	}


	public void setDestination(Airport destination) {
		this.destination = destination;
	}


	public String getAirlineCode() {
		return airlineCode;
	}


	public void setAirlineCode(String airlineCode) {
		this.airlineCode = airlineCode;
	}


	public float getBasePrice() {
		return basePrice;
	}


	public void setBasePrice(float basePrice) {
		this.basePrice = basePrice;
	}
	
	public Airline getAirline() {
		return airline;
	}

	public void setAirline(Airline airline) {
		this.airline = airline;
	}

}

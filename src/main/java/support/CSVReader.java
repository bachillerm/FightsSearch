package main.java.support;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import main.java.bo.Flight;
import main.java.enums.Airport;
import main.java.utils.EnumUtils;


/**
 * Support Class that reads a csv file and gets all the flights in it.
 * @author martabachiller
 *
 */
public class CSVReader {
    
    public static Set<Flight> getFlights(){
    	
    	String csvFile = "src/main/resources/Flights.csv";
        String line = "";
        BufferedReader br = null;
        String csvSplitBy = ",";
        
    	Set<Flight> flights = new HashSet<Flight>();
		try (BufferedReader br1 = new BufferedReader(new FileReader(csvFile))) {
	        while ((line = br1.readLine()) != null) {
	
	            // use comma as separator
	            String[] cvsFlights = line.split(csvSplitBy);
	            
	            Airport origin = (Airport) EnumUtils.search(Airport.class, cvsFlights[0]);
                Airport destination = (Airport) EnumUtils.search(Airport.class, cvsFlights[1]);
                if(origin == null || destination == null){
                	System.out.println("ERROR : Airport not found loading the flights file.");
                	flights.clear();
                	break;
                }
                Flight flight = new Flight(origin, destination, cvsFlights[2], Float.valueOf(cvsFlights[3])); 
                flights.add(flight);
	        }
	
	    } catch (IOException e) {
            e.printStackTrace();
        }
		
		return flights;
    }
}

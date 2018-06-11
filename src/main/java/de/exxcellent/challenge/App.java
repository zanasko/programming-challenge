package main.java.de.exxcellent.challenge;
import solution.WeatherAnalysis;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.csv.CSVRecord;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    public static void main(String... args) throws IOException {

    	WeatherAnalysis weatherAnalysis = new WeatherAnalysis();
    	String filePathWetterData = "src/main/resources/de/exxcellent/challenge/weather.csv";
		ArrayList<CSVRecord> weatherData = weatherAnalysis.readCSVData(filePathWetterData);
		
		String filePathFootballData = "src/main/resources/de/exxcellent/challenge/football.csv";
		ArrayList<CSVRecord> footballData = weatherAnalysis.readCSVData(filePathFootballData);
 

        String dayWithSmallestTempSpread = weatherAnalysis.calculateMinTempDifference(weatherData, "Day", "MxT", "MnT");	
        String teamWithSmallesGoalSpread = weatherAnalysis.calculateMinTempDifference(footballData, "Team", "Goals", "Goals Allowed");

        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallesGoalSpread);
        
        

    }
}

package main.java.de.exxcellent.challenge;
import main.resources.de.exxcellent.challenge.*;

import java.io.IOException;

import solutionWeather.Weather;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    public static void main(String... args) throws IOException {

        // Your preparation code …
    	Weather w = new Weather();
    	//w.wetterDatenEinlesen("C:\\Users\\Ksju\\Dropbox\\Studium\\Challange_eXXcelent\\src\\main\\resources\\de\\exxcellent\\challenge\\weather.csv");
    	//w.wetterDatenEinlesen("src\\main\\resources\\de\\exxcellent\\challenge\\weather.csv");
    	//w.getResult("src/main/resources/de/exxcellent/challenge/weather.csv");
    	//System.out.println(Integer.valueOf("5"));
    	//System.out.println(Double.parseDouble("hallo"));
    	//String csvFilePath = "./solution/weather.csv";

        String dayWithSmallestTempSpread = w.getResult("src/main/resources/de/exxcellent/challenge/weather.csv");     // Your day analysis function call …
        String teamWithSmallesGoalSpread = "A good team"; // Your goal analysis function call …

        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallesGoalSpread);
        
        

    }
}

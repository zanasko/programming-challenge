package main.java.de.exxcellent.challenge;
import main.resources.de.exxcellent.challenge.*;
import solution.Weather;

import java.io.IOException;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    public static void main(String... args) throws IOException {

    	Weather weather = new Weather();
    	Football football = new Football();

        String dayWithSmallestTempSpread = weather.dayWithSmallestTempSpread("src/main/resources/de/exxcellent/challenge/weather.csv");
        String teamWithSmallesGoalSpread = football.teamWithSmallesGoalSpread("src/main/resources/de/exxcellent/challenge/football.csv");

        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallesGoalSpread);
        
        

    }
}

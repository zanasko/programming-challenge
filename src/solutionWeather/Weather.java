package solutionWeather;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class Weather {
	
	private String day = "";
	private double minDifference = Double.POSITIVE_INFINITY;
	

	public String getResult(String csvFilePath) throws IOException {
		readCSVWeatherData(csvFilePath);
		return getDay();
	}

	private void setDay(String day) {
		this.day = day;
	}
	
	private String getDay(){
		return day;
	}
	
	
	private void setMinDifference(double minDifference) {
		this.minDifference = minDifference;
	}
	
	private double getMinDifference (){
		return minDifference;
	}
	
	

	private void readCSVWeatherData(String csvFilePath) throws IOException {

		try (

				Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
				CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);

		) 
		{
			evaluateWeatherData(csvParser);
		}

		catch (IOException e) {
			e.printStackTrace();
		}


	}

	private void evaluateWeatherData(CSVParser csvParser) {

		if (csvParser!= null)
			for (CSVRecord csvRecord : csvParser) {
				String day = csvRecord.get(0);
				String maxTemp = csvRecord.get(1);
				String minTemp = csvRecord.get(2);
				//System.out.println(day);
				//System.out.println(day);
				outputResult(day, maxTemp, minTemp);
			}
		
	}
	
	
	private void outputResult(String day, String maxTemp, String minTemp) {

		if (isNumeric(maxTemp) && isNumeric(minTemp)) {
			double difference;
			difference = Double.parseDouble(maxTemp) - Double.parseDouble(minTemp);
			if (difference < getMinDifference()) {
				setMinDifference(difference);
				setDay(day);
			}
		}
		
	}
	
	private boolean isNumeric(String value) {
		boolean isNumber;

		 try {
		    Double.parseDouble(value);
		    isNumber = true;
		 }
		 catch(NumberFormatException e) {
			 isNumber = false;
		 }
		 return isNumber;
		}
}

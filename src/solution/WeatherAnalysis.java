package solution;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class WeatherAnalysis {

	public ArrayList<CSVRecord> readCSVData(String csvFilePath) throws IOException {
		ArrayList<CSVRecord> csvRecords;

		try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
				CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);) {
			csvRecords = new ArrayList<CSVRecord>();

			for (CSVRecord csvRecord : csvParser)
				csvRecords.add(csvRecord);
		}

		catch (IOException e) {
			e.printStackTrace();
			csvRecords = null;
		}

		return csvRecords;
	}

	
	
	public String calculateMinTempDifference(ArrayList<CSVRecord> data, int positionMaxTemp, int positionMinTemp) {
		double minDifference = Double.POSITIVE_INFINITY;
		double countDifference;
		String dayWithMinTempDifference = "";
		for (CSVRecord csvRecord : data) {
			String maxTemp = csvRecord.get(positionMaxTemp);
			String minTemp = csvRecord.get(positionMinTemp);
			if (isNumeric(maxTemp) && isNumeric(minTemp)) {
				countDifference = Double.parseDouble(maxTemp) - Double.parseDouble(minTemp);
				if (countDifference < minDifference) {
					minDifference = countDifference;
					dayWithMinTempDifference = csvRecord.get(0);
					System.out.println(dayWithMinTempDifference);
				}
			}
		}
		return dayWithMinTempDifference;
	}

	
	
	private int findPositionNumber(ArrayList<CSVRecord> data, String columnName) {
		int positionNumber = -1;
		if (data != null) {
			int position;
			boolean foundPosition = false;
			for (CSVRecord csvRecord : data) {
				for (position = 0; position < csvRecord.size(); position++) {

					if (!foundPosition && csvRecord.get(position).equals(columnName)) {
						positionNumber = position;
						foundPosition = true;
					}

				}
			}
		}
		return positionNumber;
	}

	
	
	public String calculateMinTempDifference(ArrayList<CSVRecord> data, String resultColumnName, String maxTemp,
			String minTemp) {
		double minDifference = Double.POSITIVE_INFINITY;
		double countDifference;
		String dayWithMinTempDifference = "";
		int positionMaxTemp = findPositionNumber(data, maxTemp);
		int positionMinTemp = findPositionNumber(data, minTemp);
		int positionResultColumn = findPositionNumber(data, resultColumnName);
		if (positionMaxTemp != -1 && positionMinTemp != -1) {

			for (CSVRecord csvRecord : data) {
				String maxT = csvRecord.get(positionMaxTemp);
				String minT = csvRecord.get(positionMinTemp);
				if (isNumeric(maxT) && isNumeric(minT)) {

					countDifference = Double.parseDouble(csvRecord.get(positionMaxTemp))
							- Double.parseDouble(csvRecord.get(positionMinTemp));
					countDifference = Math.abs(countDifference);
					if (countDifference < minDifference) {
						minDifference = countDifference;
						dayWithMinTempDifference = csvRecord.get(positionResultColumn);

					}
				}
			}
		}

		return dayWithMinTempDifference;
	}

	
	
	private boolean isNumeric(String value) {
		boolean isNumber;

		try {
			Double.parseDouble(value);
			isNumber = true;
		} catch (NumberFormatException e) {
			isNumber = false;
		}
		return isNumber;
	}
}
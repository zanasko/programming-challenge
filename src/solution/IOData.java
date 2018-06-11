package solution;

import java.io.IOException;
import java.util.ArrayList;

public interface IOData {
	
	// Daten aus einer Datei lesen
	public ArrayList<Object> readData(String path) throws IOException;
	
	// Daten analysieren und das gewünschte Ergebnis ausrechnen
	public void analyseData(ArrayList<Object> data);
	
	// Das Ergebnis der Berechnung ausgeben
	public String getResult();
	
}

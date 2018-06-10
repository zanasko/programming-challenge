package solution;

public interface IOData {
	
	// Daten aus einer Datei lesen und zurückgeben
	public Object readData(String path);
	
	// Übergebene Daten analysieren und das gewünschte Ergebnis ausrechnen
	public void analyseData(Object data);
	
	// Das Ergebnis der Berechnung ausgeben
	public String getResult();
	
}

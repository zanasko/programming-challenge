package solution;

public interface IOData {
	
	// Daten aus einer Datei lesen und zur�ckgeben
	public Object readData(String path);
	
	// �bergebene Daten analysieren und das gew�nschte Ergebnis ausrechnen
	public void analyseData(Object data);
	
	// Das Ergebnis der Berechnung ausgeben
	public String getResult();
	
}

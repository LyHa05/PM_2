package Aufgabe054;

public enum MeinSingleton {
	INSTANZ;
	
	private MeinSingleton() {};
	
	public MeinSingleton getMeinSingleton() {
		return INSTANZ;
	}
		
}




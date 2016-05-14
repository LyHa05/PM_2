package Aufgabe02;

public class MeinSkript1 {
	
	public static void main(String[] args) {
		Queue<Integer> q1 = new Queue<Integer>(3);
		System.out.println(q1);
		System.out.println(q1.getAnzahlElemente());
		q1.enqueue(3);
		System.out.println(q1);
		System.out.println(q1.getAnzahlElemente());
		System.out.println(q1.toString());
		
		
	}

}

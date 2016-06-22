package Tutorium.Termin12;

@ToString("Auto")
public class Test extends AutoToString {
	@ToString
	private int id = 5;
	@ToString("Breite")
	protected double d = 2.3;

	@ToString("PS")
	private int getInt() {
		return 4 + 8;
	}

	public static void main(String[] args) {
		Test t = new Test();
		System.out.println(t);
	}
}
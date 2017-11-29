package tp2SD;

public class LanceurDeDormeur {

	public static void main(String[] args) {
		Thread c = new Thread(new Dormeur("C", null));
		Thread b = new Thread(new Dormeur("B", c));
		Thread a = new Thread(new Dormeur("A", b));

		a.start();
		b.start();
		c.start();

	}

}

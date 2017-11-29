package tp2SD;

public class Dormeur implements Runnable {

	String numDormeur;
	Thread atttente;

	public Dormeur(String numDormeur, Thread attente) {

		this.numDormeur = numDormeur;
		atttente = attente;
	}

	@Override
	public void run() {
		if (atttente != null) {
			try {
				atttente.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep((long) (1000 * Math.random()));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.format("Je suis le Dormeur %s et j'ai fini\n", numDormeur);
	}

}

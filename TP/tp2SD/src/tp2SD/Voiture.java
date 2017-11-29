package tp2SD;

public class Voiture implements Runnable {

	int numVoiture;
	Parking parking;

	public int getNumVoiture() {
		return numVoiture;
	}

	public void setNumVoiture(int numVoiture) {
		this.numVoiture = numVoiture;
	}

	public Voiture(int numVoiture, Parking parking) {
		super();
		this.numVoiture = numVoiture;
		this.parking = parking;
	}

	@Override
	public void run() {

		while (true) {
			if (parking.entrer(numVoiture)) {
				System.out.format("Je suis la voiture n° %s et je rentre dans le parking\n", numVoiture);
				try {
					Thread.sleep((long) (10000 * Math.random()));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.format("Je suis la voiture n° %s et je sort du parking\n", numVoiture);
				parking.sortir(numVoiture);

			} else {
				System.out.format("Je suis la voiture n° %s et j'attend\n", numVoiture);
				try {
					Thread.sleep((long) (10000 * Math.random()));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}
	}
}

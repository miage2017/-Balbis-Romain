package tp2SD;

import java.util.ArrayList;

public class Parking {

	int nombreDePlaces;
	int nombrePlaceDispo;
	ArrayList<Integer> voitureGaree = new ArrayList<Integer>();

	public Parking(int nombreDePlaces) {
		this.nombreDePlaces = nombreDePlaces;
		nombrePlaceDispo = 7;
	}

	public synchronized boolean entrer(int numVoiture) {
		if (nombrePlaceDispo > 0) {
			voitureGaree.add(numVoiture);
			--nombrePlaceDispo;
			return true;
		} else {
			return false;
		}
	}

	public synchronized void sortir(int numVoiture) {
		++nombrePlaceDispo;
		voitureGaree.remove((Object) numVoiture);
	}

	public static void main(String args[]) {
		Parking park = new Parking(7);
		for (int i = 0; i < 10; i++) {
			Thread voiture = new Thread(new Voiture(i, park));
			voiture.start();
		}
	}

}

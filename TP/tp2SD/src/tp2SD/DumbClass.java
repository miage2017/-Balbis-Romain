package tp2SD;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class DumbClass implements Runnable {
	String nom = "Toto";
	int maxIter = 1000;
	private Boolean incr;

	public DumbClass(String nom, Boolean incr) {
		this.nom = nom;
		this.incr = incr;
	}

	@Override
	public void run() {
		System.out.format("Ici le  thread %s, je debute!\n", nom);
		if (incr) {
			for (int i = 0; i < maxIter; i++) {
				System.out.format("[%s] dit  je suis Ici %d\n", nom, i);
			}
		} else {
			for (int i = maxIter; i > 0; i--) {
				System.out.format("[%s] dit  je suis Ici %d\n", nom, i);
			}
		}

		System.out.format("Ici le  thread %s, je  Termine!\n", nom);

	}

	public static void main(String[] args) throws Exception {
		String jobName = String.format("Job_%d", 0);
		DumbClass objetExec = new DumbClass(jobName, true);
		Thread job = new Thread(objetExec);
		System.out.format("Creating thread %s\n", jobName);
		job.start();
		System.out.format("Thread principal terminé  !\n");
	}

}
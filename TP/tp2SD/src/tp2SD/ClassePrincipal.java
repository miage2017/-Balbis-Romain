package tp2SD;

public class ClassePrincipal {

	public static void main(String[] args) {
		Thread monJob = new Thread(new DumbClass("1", true));
		monJob.start();
		Thread monJob2 = new Thread(new DumbClass("2", false));
		monJob2.start();
	}

}

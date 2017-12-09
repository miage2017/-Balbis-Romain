package exercice4;

import java.util.ArrayList;

public class Producteur implements Runnable{

	public ArrayList<Job> nosJobs = new ArrayList<Job>();
	private int MAXLIST = 10;

	
	public void prod() throws InterruptedException {
		while (nosJobs.size() == MAXLIST) {
            wait();
        }
		nosJobs.add(new Job());
		System.out.println("ajout job");
        notify();
	}
	
	
	public Job getJobs(){
		return nosJobs.remove(0);
	}

	@Override
	public void run() {
		
		try {
			prod();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

	
	
	public static void main(String[] args) {
		Thread prod = new Thread(new Producteur());
		prod.start();
	}
}

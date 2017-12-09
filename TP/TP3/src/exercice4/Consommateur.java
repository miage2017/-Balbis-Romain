package exercice4;

import java.util.ArrayList;

public class Consommateur implements Runnable
{
	Producteur producer;
	 
	Consommateur(Producteur p) {
        producer = p;
    }

	@Override
	public void run() {
		 while (true) {
             Job job = producer.getJobs();
             System.out.println("Got message: " + job);
             //sleep(200);
             notify();
         }
     
	}

}

package exercice4;

import java.sql.Time;

public class Job {

	private int i;

	Job(){
		i = (int) Math.random()*100;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}
}

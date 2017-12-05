package codeincomprehensible;

public class ClientSansConnection implements Runnable{

	
	@Override
	public void run() {
		int i = 0;
		while(!Thread.currentThread().isInterrupted()){
			i++;
			try {
				Thread.currentThread().sleep(100);
			} catch (InterruptedException e) {
				
			}
			System.out.println(i);
		}
		System.out.println("Fin du Thread !!");
	}
}

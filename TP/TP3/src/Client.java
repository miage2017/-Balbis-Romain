import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client implements Runnable {

	private int numCli;

	Client(int numCli) {
		this.numCli = numCli;
	}

	@Override
	public void run() {
		try {
			Socket socket = new Socket("127.0.0.1", 12000);
			System.out.println("Demande de connexion client : " + numCli);
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			Boolean ok = true;

			while (!Thread.currentThread().isInterrupted()) {

				if (Thread.currentThread().isInterrupted()) {
					System.out.println("Interruption client n :" + numCli);
					System.out.flush();
				}
				// in = new BufferedReader(new
				// InputStreamReader(socket.getInputStream()));

				out.print("hello");
				System.out.println("client : hello num :" + numCli);
				out.flush();
				

			}
			System.out.println("fermeture client : " + numCli);
			socket.close();
		} catch (IOException e) {

		}
	}
}

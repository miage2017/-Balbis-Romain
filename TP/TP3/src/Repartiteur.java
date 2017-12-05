import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Repartiteur implements Runnable {
	private ServerSocket ma_connection;

	public Repartiteur() {
		try {
			ma_connection = new ServerSocket(12000, 5);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {
			while (!Thread.currentThread().isInterrupted()) {

				Socket client = ma_connection.accept();
				ServiceClient scl = new ServiceClient(client);
				Thread t = new Thread(scl);
				t.start();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;

class ServiceClient implements Runnable {

	private ServerSocket ma_connection;
	private Socket client;
	private static int nbrclient = 1;

	public ServiceClient(ServerSocket s) {
		ma_connection = s;
	}

	@Override
	public void run() {

		while (true) {
			try {
				client = ma_connection.accept();
				// Un client se connecte on l'accepte
				System.out.println("Le client numéro " + nbrclient + " est connecté !");
				nbrclient += 1;

				Thread t = new Thread(new Messagerie(client));
				t.start();
				try {
					t.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//nbrclient--;

				client.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public int getNbrclient() {
		return nbrclient;
	}

}
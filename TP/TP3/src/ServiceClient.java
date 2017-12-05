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

	public ServiceClient(Socket s) {
		client = s;
	}

	@Override
	public void run() {

		try {

			// Un client se connecte on l'accepte
			System.out.println("Le client numéro " + nbrclient + " est connecté !");
			nbrclient += 1;

			InputStreamReader isr = new InputStreamReader(client.getInputStream(), "UTF-8");
			BufferedReader flux_entrant = new BufferedReader(isr);

			PrintWriter osw = new PrintWriter(client.getOutputStream(), true);
			osw.println("connecté au serveurJouet easy");

			String nouveau_message = flux_entrant.readLine();
			System.out.println(nouveau_message);

			while (nouveau_message == null) {
				System.out.println(nouveau_message);
				nouveau_message = flux_entrant.readLine();
				if(nouveau_message.compareTo("stop") != 0){
					break;
				}
			}

			//nbrclient--;

			client.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block

		}

	}

	public int getNbrclient() {
		return nbrclient;
	}

}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class Accepter_clients implements Runnable {

	private ServerSocket ma_connection;
	private Socket client;
	private int nbrclient = 1;
	public Accepter_clients(ServerSocket s){
		ma_connection = s;
	}

	@Override
	public void run() {

		try {
			while(true){
				client = ma_connection.accept(); // Un client se connecte on l'accepte
				System.out.println("Le client numéro "+nbrclient+ " est connecté !");
				nbrclient++;

				InputStreamReader isr = new InputStreamReader(client.getInputStream(), "UTF-8");
				BufferedReader flux_entrant = new BufferedReader(isr) ;

				PrintWriter osw = new PrintWriter(client.getOutputStream(),true);
				osw.println("connecté au serveurJouet easy");

				String nouveau_message = flux_entrant.readLine();
				//sSystem.out.println(nouveau_message);


				while(nouveau_message.compareTo("stop") != 0){
					System.out.println(nouveau_message);
					nouveau_message = flux_entrant.readLine();
				}

				client.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
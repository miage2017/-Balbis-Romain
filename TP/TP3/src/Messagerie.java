import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

public class Messagerie implements Runnable {

	public Messagerie(Socket client) {
		super();
		this.client = client;
	}

	private Socket client;

	@Override
	public void run() {
		try {
			attenteFinMessage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void attenteFinMessage() throws UnsupportedEncodingException, IOException {
		InputStreamReader isr = new InputStreamReader(client.getInputStream(), "UTF-8");
		BufferedReader flux_entrant = new BufferedReader(isr);

		PrintWriter osw = new PrintWriter(client.getOutputStream(), true);
		osw.println("connecté au serveurJouet easy");

		String nouveau_message = flux_entrant.readLine();
		System.out.println(nouveau_message);

		while (nouveau_message.compareTo("stop") != 0) {
			System.out.println(nouveau_message);
			nouveau_message = flux_entrant.readLine();
		}
	}

}

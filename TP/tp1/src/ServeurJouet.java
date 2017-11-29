import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServeurJouet {

	public void createServeur(){
		try {
			ServerSocket ma_connection = new ServerSocket(12000,5);
			Thread t = new Thread(new Accepter_clients(ma_connection));
			t.start();
			/*
			Socket client = ma_connection.accept();
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
			 */
			//ma_connection.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
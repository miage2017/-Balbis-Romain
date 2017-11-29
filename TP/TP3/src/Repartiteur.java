import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Repartiteur {

	public void createServeur() {
		try {
			ServerSocket ma_connection = new ServerSocket(12000, 5);
			ServiceClient scl = new ServiceClient(ma_connection);
			Thread t = new Thread(scl);
			t.start();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
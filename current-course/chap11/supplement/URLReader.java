package supplement;
import java.net.*;
import java.io.*;

public class URLReader {
	public static void main(String[] args) throws Exception {

		URL google = new URL("http://www.google.com.hk");
		BufferedReader in = new BufferedReader(new InputStreamReader(
				google.openStream()));

		// BufferedWriter out=new BufferedWriter(
		// new FileWriter("google_in.html"));

		String inputLine;

		while ((inputLine = in.readLine()) != null) {
			System.out.println(inputLine);

			// out.write(inputLine);
		}

		in.close();
		// out.close();
	}
}

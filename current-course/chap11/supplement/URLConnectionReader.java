package supplement;
import java.net.*;
import java.io.*;

public class URLConnectionReader {
	public static void main(String[] args) throws Exception {
		URL google = new URL("http://www.google.com.hk/");
		URLConnection gl = google.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(
				gl.getInputStream()));

		BufferedWriter out = new BufferedWriter(new FileWriter(
				"google_in_2.html"));

		String inputLine;

		while ((inputLine = in.readLine()) != null) {
			System.out.println(inputLine);

			out.write(inputLine);
		}
		in.close();
		out.close();
	}
}

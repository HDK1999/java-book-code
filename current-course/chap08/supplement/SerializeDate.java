package supplement;
import java.util.*;
import java.io.*;

public class SerializeDate {
	Date d;

	SerializeDate() {
		d = new Date();
		try {
			ObjectOutputStream s = new ObjectOutputStream(new FileOutputStream("date.ser"));
			s.writeObject(d);
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		SerializeDate b = new SerializeDate();
	}
}
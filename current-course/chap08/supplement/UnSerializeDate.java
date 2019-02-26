package supplement;
import java.util.*;
import java.io.*;

public class UnSerializeDate {
	Date d = null;

	UnSerializeDate() {
		try {
			ObjectInputStream s = new ObjectInputStream(new FileInputStream("date.ser"));
			Object o=s.readObject();
			if(o instanceof Date)
				d = (Date) o; 
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		UnSerializeDate us = new UnSerializeDate();
		System.out.println(us.d.toString());
	}
}
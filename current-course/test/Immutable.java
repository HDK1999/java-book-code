public class Immutable{
	public static String lowerCase(String s){
		return s.toLowerCase();
	}
	public static void main(String[] args){
		String s1="Java";
		String s2=s1.toLowerCase();
		System.out.println("java".equals(s2));
		System.out.println("java"==s2);
		System.out.println("Java".equals(s1));
		System.out.println("Java"==s1);
	}
}

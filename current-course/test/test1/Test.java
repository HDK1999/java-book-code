package test1;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum=0, data;
		while((data = sc.nextInt()) != 0)
		sum += data;
		System.out.println(sum);
	}
}

/**
 * this is a parent class 
 * @author Cong Sun
 * 
 */
class Transformer{
	public void shoot(){
		System.out.println("shooting enemy");
	}
}

class Autobot extends Transformer{
	public void dance(){
		System.out.println("dancing ...");
	}
	public void shoot(){
		System.out.println("shooting decepticon");
	}
}

class Decepticon extends Transformer{
	
}
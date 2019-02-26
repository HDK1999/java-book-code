import java.util.Queue;
import java.util.LinkedList;

class V{
	int i=1;
}
class Exception1 extends Exception{
	
}
class Exception2 extends Exception{
	
}

public class Test{
	public static void main(String[] args){
		try{
			throw new Exception1();
		} catch (Exception1 e){
			try{
				if(e==null)
					throw new Exception2();
				else
					throw new Exception1();
			}catch(Exception2 e1){
				System.out.println("s1");
			}catch(Exception e1){
				System.out.println("s2");
			}
		} catch (Exception e){
			System.out.println("s3");
		}
	}
}
class Parent{
final int id;
int height=1;
public Parent(int id){
	this.id=id;
}
public int getId(){ return id; }
public int getHeight(){ return height; }
}
class Child extends Parent{
final int id;
int height;
public Child(int id){
	super(id+1);
	this.id=id;
}
public int getId(){ return id; }
public int getHeight(){ return super.height; }
}

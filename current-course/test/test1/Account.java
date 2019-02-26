package test1;

import java.util.*;

public class Account{
	private int id;
	private double balance;
	private Date dateCreated;
	
	public Account(){
		dateCreated=new Date();
	}
	public Account(int i, double d){
		this.id=i;
		this.balance=d;
		dateCreated=new Date();
	}
	public void withdraw(double amount){
		if(balance<amount){
			System.out.println("withdraw error");
			return;
		}
		balance-=amount;
	}
	public void deposit(double amount){
		balance+=amount;
	}
	public void print(){
		System.out.println("<"+id+"; "+balance+"; "+dateCreated+">");
	}
	
	public static void main(String[] args){
		UserInfo user=new UserInfo("XiaoMIng", 12345678);
		Account a1=new Account(12345, 1000);
		Account a2=new Account(67890, 3000);
		
		user.addAccount(a1);
		user.addAccount(a2);
		user.transfer(0,1,500);
		user.print();
	}
}

class UserInfo{
	private ArrayList<Account> accounts;
	private String name;
	private int pid;
	
	public UserInfo(String nm, int id){
		name=nm;
		pid=id;
		accounts=new ArrayList<Account>();
	}
	
	public void addAccount(Account acc){
		this.accounts.add(acc);
	}
	public void transfer(int i, int j, double amount){
		this.accounts.get(i).withdraw(amount);
		this.accounts.get(j).deposit(amount);
	}
	public void print(){
		for(Account a: accounts)
			a.print();
	}
}
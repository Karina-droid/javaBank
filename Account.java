package bank;

import bank.*;
import java.util.Scanner;

public class Account {
	String username;
	String email;
	String password;
	double balance;
	
	Account(String username, String email, String password) {
		username = this.username;
		email = this.email;
		password = this.password;
		balance = 0;
	}

	public static void main(String[] args) {
		UserAWT menu = new UserAWT(100, 120, 40, 100, 40);
	}
		
	void checkBalance() {
		System.out.println("Your balance is " + this.balance + "\n");
	}
	
	
	void withdraw() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Which sum to withdraw? ");
		double sum = scan.nextDouble();
		while(sum<=0) {
			System.out.println("Enter a valid sum to withdraw: ");
			sum = scan.nextDouble();
		}
		if(sum > this.balance) {
			System.out.println("Your balance is not enough. To withdraw another sum - B, or choose any other option. \n");
			return;
		}this.balance -= sum;
	}
	
	
	void deposit() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Which sum to deposit? ");
		double sum = scan.nextDouble();
		while(sum<=0) {
			System.out.print("Enter a valid sum to deposit: ");
			sum = scan.nextDouble();
		}
		this.balance += sum;
	}
	
	
	void exit() {
		System.out.println("Thank you for using our service!");
	}
}

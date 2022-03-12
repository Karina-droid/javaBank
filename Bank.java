package bank;

import bank.Account;
import java.util.ArrayList;
import bank.*;

public class Bank {
	static ArrayList<Account> clients = new ArrayList<Account>();
	
	public static void register(String username, String email, String password) {
		clients.add(new bank.Account(username, email, password));
	}
	
	public static boolean login(String username, String password) {
		for(int i=0; i<clients.size(); i++) {
			if(clients.get(i).username == username) {
				if(clients.get(i).password == password) {
					return true;
				}System.out.println("Wrong username or password");
				return false;
			}
		}System.out.println("Wrong username or password");
		return false;
	}
}

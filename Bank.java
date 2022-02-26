package bank;

import java.util.ArrayList;
import bank.*;

public class Bank {
	ArrayList<Account> clients = new ArrayList<Account>();
	
	public void register(String username, String email, String password) {
		clients.add(new Account(username, email, password, 0, 0));
	}
	
	public void login(String username, String password) {
	}
}

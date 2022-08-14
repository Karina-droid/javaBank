package bank;

import bank.Account;
import java.awt.*;
import java.awt.event.*;

public class UserAWT extends Frame {
	bank.Account user = new bank.Account("Karina", "123@gmail.com", "12345");
	int x;
	int y;
	int margin;
	int width;
	int height;
	
	UserAWT(int x, int y, int margin, int width, int height) {
		Button a = new Button("Check balance");
		Button b = new Button("Withdraw");
		Button c = new Button("Deposit");
		Button d = new Button("Last transaction");
		Button e = new Button("Exit");
		
		a.setBounds(x, y + 0*margin, width, height);
		b.setBounds(x, y + margin, width, height);
		c.setBounds(x, y + 2*margin, width, height);
		d.setBounds(x, y + 3*margin, width, height);
		e.setBounds(x, y + 4*margin, width, height);
		
		a.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user.checkBalance();
			}
		});
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user.withdraw();
			}
		});
		c.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user.deposit();
			}
		});
		e.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user.exit();
			}
		});
		
		add(a);
		add(b);
		add(c);
		add(d);
		add(e);
		
		setSize(300, 400);
		setLayout(null);
		setVisible(true);
	}
	
	public static void main(String[] args) {
	}
}
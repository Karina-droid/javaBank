package bank;

import java.awt.*;
import java.awt.event.*;
import java.util.Stack;
import bank.Bank;

public class PageAWT extends Frame {
	int x;
	int y;
	int margin;
	int width;
	int height;
	
	PageAWT(int x, int y, int margin, int width, int height) {
		Stack<Component[]> actions = new Stack<Component[]>();
		Label wrong = new Label("Wrong username or password");
		wrong.setForeground(Color.RED);
		wrong.setBounds(100, 50, 2*width, height);
		Button login = new Button("Login");
		Button register = new Button("Sign up");
		Button back = new Button("back");
		back.setBounds(10, 40, 50, 25);
		Component[] frontComps = {login, register};
		actions.push(frontComps);
		layoutPage(frontComps, back);
		
		login.setBounds(x, y, width, height);
		register.setBounds(x, y + margin, width, height);
		
		Label username = new Label("Username");
		TextField enterName = new TextField();
		Label password = new Label("Password");
		TextField enterPassword = new TextField();
		Button logIn = new Button("Log in");
		Component[] loginComps = {username, enterName, password, enterPassword, logIn};
		username.setBounds(x, y, width, height);
		enterName.setBounds(x, y + margin, width, height);
		password.setBounds(x, y + 2*margin, width, height);
		enterPassword.setBounds(x, y + 3*margin, width, height);
		logIn.setBounds(80, y + 4*margin, 50, 25);

		Label usernameR = new Label("Username");
		TextField enterNameR = new TextField();
		Label passwordR = new Label("Password");
		TextField enterPasswordR = new TextField();
		Label email = new Label("E-mail");
		TextField enterEmail = new TextField();
		Button submitR = new Button("submit");
		Component[] registerComps = {usernameR, enterNameR, passwordR, enterPasswordR, email, enterEmail, submitR};
		
		usernameR.setBounds(x, y, width, height);
		enterNameR.setBounds(x, y + margin, width, height);
		passwordR.setBounds(x, y + 2*margin, width, height);
		enterPasswordR.setBounds(x, y + 3*margin, width, height);
		email.setBounds(x, y + 4*margin, width, height);
		enterEmail.setBounds(x, y + 5*margin, width, height);
		submitR.setBounds(120, y + 6*margin, 50, 25);
		
		setSize(300, 400);
		setLayout(null);
		setVisible(true);
		
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(actions.isEmpty()) layoutPage(frontComps, back);
				else {
					actions.pop();
					layoutPage(actions.peek(), back);
				}
			}
		});
		
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actions.push(loginComps);
				layoutPage(loginComps, back);
			}
		});
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layoutPage(registerComps, back);
				actions.push(registerComps);
			}

		});
		submitR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Bank.register(username.getText(), email.getText(), password.getText());
			}
		});
		logIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean enter = Bank.login(username.getText(), password.getText());
				if(enter == true) System.out.println("Welcome, " + username.getText());
				else add(wrong);
			}
		});
	}
	
	public void layoutPage(Component[] comps, Button b) {
		removeAll();
		add(b);
		for(Component comp: comps) {
			add(comp);
		} 
	}
	
	public static void main(String[] args) {
		PageAWT frontPage = new PageAWT(100, 120, 40, 100, 40);
	}
}
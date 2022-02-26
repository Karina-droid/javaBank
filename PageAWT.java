package bank;

import java.awt.*;
import java.awt.event.*;

public class PageAWT extends Frame {
	int x;
	int y;
	int margin;
	int width;
	int height;
	Component[] frontComps;
	Component[] loginComps;
	Component[] registerComps;
	
	PageAWT(int x, int y, int margin, int width, int height) {
		Button login = new Button("Login");
		Button register = new Button("Sign up");
		login.setBounds(x, y, width, height);
		register.setBounds(x, y + margin, width, height);
		add(login);
		add(register);
		
		Label username = new Label("Username");
		TextField enterName = new TextField();
		Label password = new Label("Password");
		TextField enterPassword = new TextField();
		Button submit = new Button("submit");
		Component[] loginComps = {username, enterName, password, enterPassword, submit};
		this.loginComps = loginComps;

		Label username1 = new Label("Username");
		TextField enterName1 = new TextField();
		Label password1 = new Label("Password");
		TextField enterPassword1 = new TextField();
		Label email = new Label("E-mail");
		TextField enterEmail = new TextField();
		Button submit1 = new Button("submit");
		Component[] registerComps = {username1, enterName1, password1, enterPassword1, email, enterEmail, submit1};
		this.registerComps = registerComps;
		
		setSize(300, 400);
		setLayout(null);
		setVisible(true);
		
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeAll();
				for(int i=0; i<loginComps.length; i++) {
					loginComps[i].setBounds(x, y + i*margin, width, height);
					add(loginComps[i]);
				}
			}
		});
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeAll();
				for(int i=0; i<registerComps.length; i++) {
					registerComps[i].setBounds(x, y + i*margin, width, height);
					add(registerComps[i]);
				}
			}

		});
	}
	
	public static void main(String[] args) {
		PageAWT frontPage = new PageAWT(100, 120, 40, 100, 40);
	}
}


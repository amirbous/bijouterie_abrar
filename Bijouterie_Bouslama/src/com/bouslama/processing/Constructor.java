package com.bouslama.processing;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;



public class Constructor {

	
	
	public static void main(String[] args) {
		
		login();
			
	}
	
	static void login() {
		JPasswordField session_pwd = new JPasswordField();
		int read_password = JOptionPane.showConfirmDialog(null, session_pwd, "Bijouterie Bouslama", JOptionPane.OK_CANCEL_OPTION);
		
		if(read_password == 0){
			
			if(new String(session_pwd.getPassword()).equals("1234")) {
				
				frmMain frmmain = new frmMain();
			
			}
			else {
				JOptionPane.showMessageDialog(new JFrame(), "wrong password", "Dialog",
				        JOptionPane.ERROR_MESSAGE);
				login();
			}
			
		}
		else {
			System.exit(0);
		}
	}
	}
	

package com.abrar.processing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class frmVente extends JFrame{
	
	JCheckBox possible_id = new JCheckBox();
	JLabel reference_label = new JLabel("reference");
	JLabel entree_prix = new JLabel("prix");
	JTextField lire_reference = new JTextField();
	JTextField lire_prix = new JTextField();
	JButton check_item = new JButton("verifier");
	
	
	public frmVente() {
		String reference_tosale = "0015_2021";
		
		this.setLayout(new FlowLayout());
		check_item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				MarchandiseManagement management = new MarchandiseManagement();
				
				System.out.println(management.match_item(reference_tosale));
				
				
			}
		});
		this.add(check_item);
		setVisible(true);
		setSize(500,700);
		
		
		
		
		
		
	}
	
	
	

}

package com.bouslama.processing;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import net.miginfocom.swing.MigLayout;

public class frmAddItem extends JFrame{
	
	List<Marchandise> items;
	int reference_pointer;
	JPanel reference_panel = new JPanel(new MigLayout("wrap 2"));
	JPanel date_entree_panel = new JPanel(new MigLayout("wrap 3"));
	JPanel date_sortie_panel = new JPanel(new MigLayout("wrap 3"));
	JComboBox<String> jour_entree = new JComboBox<String>();
	JComboBox<String> mois_entree = new JComboBox<String>();
	JComboBox<String> jour_sortie = new JComboBox<String>();
	JComboBox<String> mois_sortie = new JComboBox<String>();
	JLabel reference = new JLabel("reference");
	JLabel designation = new JLabel("designation");
	String[] fournisseurs = {"pas de selection", "B.M.H", "H.M.M"};
	JComboBox lire_fournisseur = new JComboBox(fournisseurs);
	JLabel date_entree = new JLabel("date d'entree");
	JLabel poids = new JLabel("poids");
	JLabel prix_gramme = new JLabel("prix gramme");
	JLabel prix_revient = new JLabel("prix de revient");
	JLabel date_sortie = new JLabel("date de sortie");
	JLabel prix_vente = new JLabel("prix de vente");
	JTable added_data;
	JTextField lire_reference = new JTextField();
	JTextField lire_reference_id = new JTextField();
	JTextField lire_designation = new JTextField();
	JLabel fournisseur = new JLabel("fournisseur");
	JTextField annee_entree = new JTextField();
	JTextField lire_poids = new JTextField();
	JTextField lire_prix_gramme = new JTextField();
	JTextField lire_prix_revient = new JTextField();
	JTextField annee_sortie = new JTextField();
	JTextField lire_prix_vente = new JTextField();
	String[] columnnames = {"proprietées", "suppr"};
	JButton confirmer = new JButton("confirmer");
	//"0129_2021 bague H.M.H 25/07/2018 6 135 995 00 0"
	Object[][] donne = {};
	Object[][] table_data;
	JButton add_data = new JButton("ajouter l'item");
	JScrollPane tablescrollpane;
	String fournisseur_selectionnee;
	JPanel read_data = new JPanel(new MigLayout("wrap 2"));
	JPanel display_data = new JPanel();
	
	
	
	public frmAddItem() {
		
		
		jour_entree.addItem("-");
		mois_entree.addItem("-");
		jour_sortie.addItem("-");
		mois_sortie.addItem("-");
		for(int i = 1; i <= 31; i++) {
			if(i/10 == 0) {
				jour_entree.addItem("0" + String.valueOf(i));
				jour_sortie.addItem("0" + String.valueOf(i));
					
			}
			else{
			jour_entree.addItem(String.valueOf(i));
			jour_sortie.addItem(String.valueOf(i));
			}	
			
			if(i <= 12) {
				if(i/10 == 0) {
					mois_entree.addItem("0" + String.valueOf(i));
					mois_sortie.addItem("0" + String.valueOf(i));
						
				}
				else{
				mois_entree.addItem(String.valueOf(i));
				mois_sortie.addItem(String.valueOf(i));
				}}
			
		}
		
		
		
		fournisseur_selectionnee = "pas de selection";
		
		MarchandiseManagement management = new MarchandiseManagement();
		
		try{
			management.scanner = new Scanner(management.data_file);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		reference_pointer = 1;
		while(management.scanner.hasNext()) {
			
			management.scanner.next();
			reference_pointer ++;
			
		}
		getreference(reference_pointer);
		
		setSize(600, 670);
		
		setLayout(new FlowLayout());
		setVisible(true);
		
		lire_reference.setColumns(7);
		
		
		lire_fournisseur.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				fournisseur_selectionnee = lire_fournisseur.getSelectedItem().toString();
				
			}
		});
		
		lire_designation.setColumns(15);
		lire_reference_id.setColumns(7);
		//
		annee_entree.setColumns(4);
		lire_poids.setColumns(15);
		lire_prix_gramme.setColumns(15);
		lire_prix_revient.setColumns(15);
		annee_sortie.setColumns(4);
		lire_prix_vente.setColumns(15);
		read_data.add(reference);
		
		 items =new ArrayList<Marchandise>();
	
		
		reference_panel.add(lire_reference);
		reference_panel.add(lire_reference_id);
	
		date_entree_panel.add(jour_entree);
		date_entree_panel.add(mois_entree);
		date_entree_panel.add(annee_entree);
		date_sortie_panel.add(jour_sortie);
		date_sortie_panel.add(mois_sortie);
		date_sortie_panel.add(annee_sortie);
		
		read_data.add(reference_panel);
		
		read_data.add(designation);
		read_data.add(lire_designation);
		read_data.add(fournisseur);
		read_data.add(lire_fournisseur);
		read_data.add(date_entree);
		read_data.add(date_entree_panel);
		read_data.add(poids);
		read_data.add(lire_poids);
		read_data.add(prix_gramme);
		read_data.add(lire_prix_gramme);
		read_data.add(prix_revient);
		read_data.add(lire_prix_revient);
		read_data.add(date_sortie);
		read_data.add(date_sortie_panel);
		read_data.add(prix_vente);
		read_data.add(lire_prix_vente);
		added_data = new JTable(donne, columnnames);
		add_data.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand() == "ajouter l'item") {
					Marchandise marchandise = new Marchandise(lire_reference.getText() + "_" + lire_reference_id.getText(), lire_designation.getText(),
							"2016", fournisseur_selectionnee, 
							Float.parseFloat(lire_poids.getText()), Integer.parseInt(lire_prix_gramme.getText()),
							Integer.parseInt(lire_prix_revient.getText()),
							"2019", Integer.parseInt(lire_prix_vente.getText()));
					items.add(marchandise);
					System.out.println(items.size());				}
				donne = new Object[items.size()][9];
				table_data = new Object[items.size()][2];
				for(int i = 0; i <= items.size() - 1; i++) {
					donne[i][0] = items.get(i).getreference();
					donne[i][1] = items.get(i).getdesignation();
					donne[i][2] = items.get(i).getdate_entree();
					donne[i][3] = items.get(i).getfournisseur();
					donne[i][4] = items.get(i).getpoid();
					donne[i][5] = items.get(i).getprix_gramme();
					donne[i][6] = items.get(i).getprix_revient();
					
					if(items.get(i).getdate_sortie().equals("00")) {
						donne[i][7] = "-";}else{donne[i][7] = items.get(i).getdate_sortie();}
					
					if(items.get(i).getprix_vente() == 0) {
						donne[i][8] = "-";}else{donne[i][8] = items.get(i).getprix_vente();}
					String s = donne[i][0].toString() + " " +donne[i][1].toString() + " " + donne[i][2].toString() + " " + 
							donne[i][3].toString() + " " + donne[i][4].toString() + " " + donne[i][5].toString() + " " + 
							donne[i][6].toString() + " " + donne[i][7].toString() + " " + donne[i][8].toString();
					table_data[i][0] = s;
					table_data[i][1] = "x";
				}
				
				added_data.setModel(new DefaultTableModel(table_data ,columnnames));
				added_data.getColumn("suppr").setPreferredWidth(30);
				added_data.getColumn("proprietées").setPreferredWidth(550);
				
				reference_pointer = Integer.parseInt(lire_reference.getText()) + 1;
				getreference(reference_pointer);
				
				jour_entree.setSelectedIndex(0);
				mois_entree.setSelectedIndex(0);
				jour_sortie.setSelectedIndex(0);
				mois_sortie.setSelectedIndex(0);
				annee_entree.setText("");
				lire_designation.setText("");
				lire_fournisseur.setSelectedIndex(0);
				lire_poids.setText("");
				lire_prix_gramme.setText("");
				lire_prix_revient.setText("");
				annee_sortie.setText("");
				lire_prix_vente.setText("");
				
				
			}
		});
		
		
		tablescrollpane = new JScrollPane(added_data);
		//
		this.add(read_data);
		this.add(add_data);
		//
		added_data.setRowHeight(60);
		confirmer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				
				if(items.size() != 0) {
					for(int i= 0; i < items.size(); i++) {
					
					
					MarchandiseManagement data_handling = new MarchandiseManagement();
					StringBuilder ds = new StringBuilder(table_data[i][0].toString());
					for(int j = 0; j < ds.length(); j++) {
						if(ds.charAt(j) == ' ') {
							ds.setCharAt(j, '-');
						}
					}
					
					data_handling.insert_data(ds.toString());
					
					
					
					}
					dispose();
				
				}
				
				
				
				
			}
		});
		
		added_data.getColumn("suppr").setPreferredWidth(30);
		//added_data.set
		added_data.getColumn("proprietées").setPreferredWidth(550);
		
		
		tablescrollpane.setPreferredSize(new Dimension(580, 300));
		
		
		
		this.add(tablescrollpane);
		this.add(confirmer);
		
	}
	public void getreference(int reference_pointer) {
		int x = 10;
		while(reference_pointer / x != 0) {
			x = x  * 10;
			
		}
		switch(x) {
		
		case 10: lire_reference.setText("000" + String.valueOf(reference_pointer)); break;
		case 100: lire_reference.setText("00" + String.valueOf(reference_pointer)); break;
		case 1000: lire_reference.setText("0" + String.valueOf(reference_pointer)); break;
		case 10000: lire_reference.setText(String.valueOf(reference_pointer));
		
		}	
	}
}



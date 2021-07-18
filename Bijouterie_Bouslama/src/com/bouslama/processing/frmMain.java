package com.bouslama.processing;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import net.miginfocom.layout.Grid;
import net.miginfocom.swing.MigLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class frmMain extends JFrame{
	public JLabel bijouterie = new JLabel("Bijouterie Bouslama");
	JButton add_item = new JButton("ajouter");
	JButton vente_item = new JButton("vente");
	static JTable table;
	JScrollPane tablescrollPane;
	static Object[][] data;
	static String[] columnNames = {"reference", "designation", "date_entree", "fournisseur", "poid", "prix_gramme", "prix_revient", "date_sortie", "prix_vente"};
	
	List<Marchandise> items;
	
	//
	public frmMain() {
		
		
		table = new JTable();
		update_data(data);
		
		
		this.setLayout(null);
		 
		this.setPreferredSize(new Dimension(1000, 600));
		this.setResizable(false);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		 
		
		
		tablescrollPane = new JScrollPane(table);
		
		add_item.setBounds(10, 450, 100, 20);
		vente_item.setBounds(130, 450, 100, 20);
		vente_item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		add_item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent action) {
				if(action.getActionCommand() == "ajouter") {
					frmAddItem frmadditem = new frmAddItem();
					
				}
				
			}
		});
		bijouterie.setBounds(10, 10, 200, 20);
		tablescrollPane.setBounds(10, 50, 800, 400);
		
		add(add_item);
		add(vente_item);
		add(bijouterie);
		add(tablescrollPane);
		this.pack();
		this.setVisible(true);
	}
	
	
	
	//
	public static void update_data(Object[][] data) {
		MarchandiseManagement data_handling = new MarchandiseManagement();
		data_handling.read_data();
		
		data = new Object[data_handling.items.size()][9];
		for(int i = 0; i <= data_handling.items.size() - 1; i++) {
			data[i][0] = data_handling.items.get(i).getreference();
			data[i][1] = data_handling.items.get(i).getdesignation();
			data[i][2] = data_handling.items.get(i).getdate_entree();
			data[i][3] = data_handling.items.get(i).getfournisseur();
			data[i][4] = data_handling.items.get(i).getpoid();
			data[i][5] = data_handling.items.get(i).getprix_gramme();
			data[i][6] = data_handling.items.get(i).getprix_revient();
			
			if(data_handling.items.get(i).getdate_sortie().equals("00")) {
				data[i][7] = "-";}else{data[i][7] = data_handling.items.get(i).getdate_sortie();}
			
			if(data_handling.items.get(i).getprix_vente() == 0) {
				data[i][8] = "-";}else{data[i][8] = data_handling.items.get(i).getprix_vente();}
			
		}
		table.setModel(new DefaultTableModel(data, columnNames));
		
	}

}

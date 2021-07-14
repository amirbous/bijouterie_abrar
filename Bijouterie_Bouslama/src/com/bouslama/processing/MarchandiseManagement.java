package com.bouslama.processing;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MarchandiseManagement {
	List <Marchandise> items;
	String[] item  = new String[9];
	public Scanner scanner;
	private FileWriter writer;
	File data_file = new File("files/data");
	
	
	public void read_data() {
		
			items = new ArrayList<Marchandise>();
			try{
				scanner = new Scanner(data_file);
			 
			while(scanner.hasNextLine()) {
				
			
				item = scanner.next().split("-");
				
				Marchandise marchandise;
				marchandise = new Marchandise(item[0], item[1], item[2], item[3], Float.parseFloat(item[4]), Integer.parseInt(item[5]), Integer.parseInt(item[6]), item[7], Integer.parseInt(item[8]));
				items.add(marchandise);
				
				}
			}			
			catch (Exception e) {
			System.out.println("waldehe tneket");		
									
			}
		
			
	
	}
	public void insert_data(String data){
		
		try {
		writer = new FileWriter(data_file, true); 
		writer.write(System.getProperty("line.separator"));
		writer.write(data);
		
		System.out.println("working");
		writer.close();
		}
		catch (Exception e) {
			System.out.println("error");
		}
		
		
	}
	
	
	}	



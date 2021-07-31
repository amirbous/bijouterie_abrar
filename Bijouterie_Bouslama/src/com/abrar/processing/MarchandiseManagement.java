package com.abrar.processing;

import java.beans.DesignMode;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class MarchandiseManagement {
	private String sold_line;
	static final String Date_REGEX =
            "^(?:(?:(?:0?[13578]|1[02])(\\/|-|\\.)31)\\1|" +
            "(?:(?:0?[1,3-9]|1[0-2])(\\/|-|\\.)(?:29|30)\\2))" +
            "(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:0?2(\\/|-|\\.)29\\3" +
            "(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|" +
            "[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|" +
            "^(?:(?:0?[1-9])|(?:1[0-2]))(\\/|-|\\.)(?:0?[1-9]|1\\d|" +
            "2[0-8])\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
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
	
	
	public String match_item(String complete_reference) {
		sold_line = "";
		try{
			scanner = new Scanner(data_file);
			
			while(scanner.hasNextLine()) {
				sold_line = scanner.next();
				if(sold_line.substring(0, 9).equals(complete_reference)) {
					
					break;
				
					}
				
			}
			return sold_line;
		
		}			
		catch (Exception e) {
		System.out.println("waldehe tneket");		
		return "item deja vendu";
		}
		
		
	}
	
	
	}	



package com.abrar.processing;

import java.sql.Blob;

public class Marchandise {
	
	private String reference;
	private String date_entree;
	private String designation;
	private String fournisseur; 
	private float poid;
	private int prix_gramme;
	private int prix_revient;
	private String date_sortie;
	private int prix_vente;
	public Marchandise(String reference, String designation, String date_entree, String fournisseur, float poid, int prix_gramme, int prix_revient, String date_sortie, int prix_vente) {
		this.reference = reference;
		this.date_entree = date_entree;
		this.designation = designation;
		this.fournisseur = fournisseur;
		this.poid = poid;
		this.prix_gramme = prix_gramme;
		this.prix_revient = prix_revient;
		this.date_sortie = date_sortie;
		this.prix_vente = prix_vente; 
	}
	public Marchandise() {
		
	}
	public String getreference() {
		return reference;
	}
	public void setreference(String reference) {
		this.reference = reference;
	}
	public String getdate_entree() {
		return date_entree;
	}
	public void setdate_entree(String date_entree) {
		this.date_entree = date_entree;
	}
	public String getdesignation() {
		return designation;
	}
	public void setdesignation(String designatin) {
		this.designation = designation;
	}
	public String getfournisseur() {
		return fournisseur;
	}
	public void setfournisseur(String fournisseur) {
		this.fournisseur = fournisseur;
	}
	public float getpoid() {
		return poid;
	}
	public void setpoid(float poid) {
		this.poid = poid;
	}
	public int getprix_gramme() {
		return prix_gramme;
	}
	public void setprix_gramme(int prix_gramme) {
		this.prix_gramme = prix_gramme;
	}
	public int getprix_revient() {
		return prix_revient;
	}
	public void setprix_revient(int prix_revient) {
		this.prix_revient = prix_revient;
	}
	public String getdate_sortie() {
		return date_sortie;
	}
	public void setdate_sortie(String date_sortie) {
		this.date_sortie = date_sortie;
	}
	public int getprix_vente() {
		return prix_vente;
	}
	public void setprix_vente(int prix_vente) {
		this.prix_vente = prix_vente;
	}
	

}

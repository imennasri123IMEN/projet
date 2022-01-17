package edu.project.transport;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class utili implements Serializable {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int cin;
		private String nom;
		private String prenom;

		
	
		

		public utili() {
			super();
		}

		

		public int getCin() {
			return cin;
		}

		public void setCin(int cin) {
			this.cin = cin;
		}
		

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public String getPrenom() {
			return prenom;
		}

		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}

		

		

		

		

		
		
		
		

	}



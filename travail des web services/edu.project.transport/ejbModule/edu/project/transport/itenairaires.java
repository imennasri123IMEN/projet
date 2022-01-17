package edu.project.transport;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class itenairaires implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int code;
	private int trajet;
	private int vitesse;
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getTrajet() {
		return trajet;
	}

	public void setTrajet(int trajet) {
		this.trajet = trajet;
	}

	public int getVitesse() {
		return vitesse;
	}

	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}

	public itenairaires(int code, int trajet, int vitesse) {
		super();
		this.code = code;
		this.trajet = trajet;
		this.vitesse = vitesse;
	}

	public itenairaires() {
		super();
	}

}
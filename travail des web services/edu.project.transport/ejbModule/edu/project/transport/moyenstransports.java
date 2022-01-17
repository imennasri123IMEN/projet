package edu.project.transport;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class moyenstransports implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int code;
	@Column(name = "temp_arrivee")
	private int tempa;
	@Column(name = "temp_sortie")
	private int temps;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getTempa() {
		return tempa;
	}

	public void setTempa(int tempa) {
		this.tempa = tempa;
	}

	public int getTemps() {
		return temps;
	}

	public void setTemps(int temps) {
		this.temps = temps;
	}

	public moyenstransports() {
		super();
	}

}
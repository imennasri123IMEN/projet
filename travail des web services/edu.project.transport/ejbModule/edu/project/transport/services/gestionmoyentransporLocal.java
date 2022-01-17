package edu.project.transport.services;

import java.util.List;

import edu.project.transport.moyenstransports;


public interface gestionmoyentransporLocal {



	void updatemoyenstransports(moyenstransports moyenstransports);

	moyenstransports findmoyenstransportsByCode(int code);

	void deletemoyenstransports(moyenstransports moyenstransports);

	List<moyenstransports> findAllmoyenstransports();
	public void addumoyenstransports(moyenstransports moyenstransports);
	

	
	
}

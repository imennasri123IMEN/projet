package edu.project.transport.services;

import java.util.List;

import edu.project.transport.moyenstransports;


public interface gestionmoyentransportRemote {

	void updatemoyenstransports(moyenstransports moyenstransports);

	moyenstransports findmoyenstransportsByCode(int code);

	void deletemoyenstransports(moyenstransports moyenstransports);

	List<moyenstransports> findAllmoyenstransports();


	

	void addumoyenstransports(moyenstransports abons);


	
}

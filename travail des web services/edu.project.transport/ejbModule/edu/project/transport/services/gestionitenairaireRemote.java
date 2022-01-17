package edu.project.transport.services;

import java.util.List;

import edu.project.transport.itenairaires;



public interface gestionitenairaireRemote {
	void updateitenairaires(itenairaires itenairaires);

	itenairaires finditenairairesByCode(int code);

	void deleteitenairaires(itenairaires itenairaires);

	List<itenairaires> findAllitenairaires();



	
}

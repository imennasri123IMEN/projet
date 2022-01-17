package edu.project.transport.services;

import java.util.List;


import edu.project.transport.utili;

public interface gestionutilisateurLocal {

	utili findutilisateurByCin(int cin);

	void deleteutilisateur(utili utili);

	List<utili> findAllutilisateur();

	utili loginutilisateur(String mail, String password);
	
	void updateutilisateur(utili utili);

	

	
	
}

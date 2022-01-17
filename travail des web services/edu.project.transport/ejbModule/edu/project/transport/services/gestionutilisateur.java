package edu.project.transport.services;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import edu.project.transport.utili;




@Stateless
public class gestionutilisateur implements gestionutilisateurRemote, gestionutilisateurLocal {
    @PersistenceContext( unitName = "edu.project.transport" )
    private EntityManager em;
    
	

	@Override
	public void updateutilisateur(utili utili) {
		
		em.merge(utili);
	}
	public void addutilisateur(utili utili)
	{
		
		em.persist(utili);
	}
	@Override
	public utili findutilisateurByCin(int cin) 
	{
		return em.find(utili.class, cin);
	}

	@Override
	public void deleteutilisateur(utili utili)
	{
		em.remove(em.merge(utili));
	}
	
	 
	@Override
	public List<utili> findAllutilisateur()
	{
			Query et = em.createQuery("From utili");
				return et.getResultList();									
	}

	@Override
	public utili loginutilisateur(String mail, String password)
	{
		try {
		Query req=em.createQuery("select e from utili e where e.mail=:m AND e.password=:p");
				req.setParameter("m",mail);
				req.setParameter("p",password);
				return  (utili) req.getSingleResult();
		}
		catch (Exception e)
		{
			return null;
		}
	}

	

	


}


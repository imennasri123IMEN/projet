package edu.project.transport.services;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.project.transport.moyenstransports;






@Stateless
public class gestionmoyentranspor implements gestionmoyentransportRemote, gestionmoyentransporLocal {
    @PersistenceContext( unitName = "edu.project.transport" )
    private EntityManager em;
    
	

	@Override
	public void updatemoyenstransports(moyenstransports moyenstransports) {
		
		em.merge(moyenstransports);
	}
	public void addmoyenstransports(moyenstransports moyenstransports)
	{
		
		em.persist(moyenstransports);
	}
	@Override
	public moyenstransports findmoyenstransportsByCode(int code) 
	{
		return em.find(moyenstransports.class, code);
	}

	@Override
	public void deletemoyenstransports(moyenstransports moyenstransports)
	{
		em.remove(em.merge(moyenstransports));
	}
	public void addumoyenstransports(moyenstransports moyenstransports)
	{
		
		em.persist(moyenstransports);
	}
	 
	@Override
	public List<moyenstransports> findAllmoyenstransports()
	{
			Query et = em.createQuery("From moyenstransports");
				return et.getResultList();									
	}

	
	}

	

	





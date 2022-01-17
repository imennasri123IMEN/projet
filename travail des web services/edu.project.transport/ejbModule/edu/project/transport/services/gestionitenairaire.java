package edu.project.transport.services;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.project.transport.itenairaires;








@Stateless
public class gestionitenairaire implements gestionitenairaireRemote, gestionitenairaireLocal {
    @PersistenceContext( unitName = "edu.project.transport" )
    private EntityManager em;
    
	

	@Override
	public void updateitenairaires(itenairaires itenairaires) {
		
		em.merge(itenairaires);
	}
	public void additenairaires(itenairaires moyenstransports)
	{
		
		em.persist(moyenstransports);
	}
	@Override
	public itenairaires finditenairairesByCode(int code) 
	{
		return em.find(itenairaires.class, code);
	}

	@Override
	public void deleteitenairaires(itenairaires itenairaires)
	{
		em.remove(em.merge(itenairaires));
	}
	public void adduitenairaires(itenairaires itenairaires)
	{
		
		em.persist(itenairaires);
	}
	 
	@Override
	public List<itenairaires> findAllitenairaires()
	{
			Query et = em.createQuery("From itenairaires");
				return et.getResultList();									
	}

	
	}

	

	





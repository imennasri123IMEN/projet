package tn.iset.rest.ressources;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


import edu.project.transport.utili;

import edu.project.transport.services.gestionutilisateurRemote;

@Path("/utilisateurs")
public class Ressourceutilisateur {
	
		@EJB
		private gestionutilisateurRemote gestion;
		List<utili> utilisateurs = new ArrayList<utili>();
				
		@GET
		
		@Produces(MediaType.APPLICATION_JSON)
		public 	List<utili> getabon() {
			List<utili> abons = gestion.findAllutilisateur();
			return abons;
		}
		

		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public Response getutilisateurs() {
			List<utili> abons = gestion.findAllutilisateur();
			if (!abons.isEmpty()) {
				return Response.ok(abons).build();
			} else {
				return Response.status(Response.Status.NOT_FOUND).build();
			}
		}

		@GET
		@Produces({ MediaType.APPLICATION_JSON })
		@Path("{cin}")
		public utili getutilisateur(@PathParam("cin") String cin) {
			return gestion.findutilisateurByCin(Integer.parseInt(cin));
		}

		@DELETE
		@Path("{cin}")
		public Response deleteutilisateur(@PathParam("cin") String cin) {
			utili a = gestion.findutilisateurByCin(Integer.parseInt(cin));
			gestion.deleteutilisateur(a);
			return Response.status(Status.OK).entity("Remove").build();

		}

		
		@POST
		@Consumes({MediaType.APPLICATION_JSON} )
		public Response Ajout(utili abons) { 
			gestion.addutilisateur(abons);
			return Response.status(Status.CREATED).entity("Ajout utilisateur en XML/JSON").build();
		}

		@PUT
		@Consumes(MediaType.APPLICATION_JSON)
		public Response modifUser(utili a) {
			gestion.updateutilisateur(a);
			return Response.status(Status.OK).entity("update succesfull").build();
		}
		
		@POST
		@Path(value="login")
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		public Response login(@FormParam("mail") String mail, @FormParam("password") String password) {
			
			if (gestion.loginutilisateur(mail, password) != null) {
				return Response.status(Response.Status.OK).entity("log in succefull").build();
						
			} else
				return Response.status(Response.Status.NOT_FOUND).entity("utilisateur not found").build();

		}
		
}
		
		

		

		
	


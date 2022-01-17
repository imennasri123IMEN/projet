package tn.iset.rest.ressources;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import edu.project.transport.services.gestionitenairaireRemote;
import edu.project.transport.itenairaires;

@Path("/itenairaires")
public class Ressourceitenairaire {
	
		@EJB
		private gestionitenairaireRemote gestion;
		List<itenairaires> itenairaires = new ArrayList<itenairaires>();
				
		@GET
		
		@Produces(MediaType.APPLICATION_JSON)
		public 	List<itenairaires> getabon() {
			List<itenairaires> abons = gestion.findAllitenairaires();
			return abons;
		}
		

		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public Response getmoyenstransports() {
			List<itenairaires> abons = gestion.findAllitenairaires();
			if (!abons.isEmpty()) {
				return Response.ok(abons).build();
			} else {
				return Response.status(Response.Status.NOT_FOUND).build();
			}
		}

		@GET
		@Produces({ MediaType.APPLICATION_JSON })
		@Path("{code}")
		public itenairaires getitenairaires(@PathParam("code") String cin) {
			return gestion.finditenairairesByCode(Integer.parseInt(cin));
		}

		@DELETE
		@Path("{code}")
		public Response deleteutilisateur(@PathParam("code") String cin) {
			itenairaires a = gestion.finditenairairesByCode(Integer.parseInt(cin));
			gestion.deleteitenairaires(a);
			return Response.status(Status.OK).entity("Remove").build();

		}

		
		
		@PUT
		@Consumes(MediaType.APPLICATION_JSON)
		public Response modifUser(itenairaires a) {
			gestion.updateitenairaires(a);
			return Response.status(Status.OK).entity("update succesfull").build();
		}

		
}
		
		

		

		
	


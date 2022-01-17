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

import edu.project.transport.services.gestionmoyentransportRemote;

import edu.project.transport.moyenstransports;

@Path("/moyenstransports")
public class Ressourcemoyenstransports {
	
		@EJB
		private gestionmoyentransportRemote gestion;
		List<moyenstransports> moyenstransports = new ArrayList<moyenstransports>();
				
		@GET
		
		@Produces(MediaType.APPLICATION_JSON)
		public 	List<moyenstransports> getabon() {
			List<moyenstransports> abons = gestion.findAllmoyenstransports();
			return abons;
		}
		

		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public Response getmoyenstransports() {
			List<moyenstransports> abons = gestion.findAllmoyenstransports();
			if (!abons.isEmpty()) {
				return Response.ok(abons).build();
			} else {
				return Response.status(Response.Status.NOT_FOUND).build();
			}
		}

		@GET
		@Produces({ MediaType.APPLICATION_JSON })
		@Path("{code}")
		public moyenstransports getutilisateur(@PathParam("code") String cin) {
			return gestion.findmoyenstransportsByCode(Integer.parseInt(cin));
		}

		@DELETE
		@Path("{code}")
		public Response deleteutilisateur(@PathParam("code") String cin) {
			moyenstransports a = gestion.findmoyenstransportsByCode(Integer.parseInt(cin));
			gestion.deletemoyenstransports(a);
			return Response.status(Status.OK).entity("Remove").build();

		}

		
		@POST
		@Consumes({MediaType.APPLICATION_JSON} )
		public Response Ajout(moyenstransports abons) { 
			gestion.addumoyenstransports(abons);
			return Response.status(Status.CREATED).entity("Ajout moyens en XML/JSON").build();
		}

		@PUT
		@Consumes(MediaType.APPLICATION_JSON)
		public Response modifUser(moyenstransports a) {
			gestion.updatemoyenstransports(a);
			return Response.status(Status.OK).entity("update succesfull").build();
		}

		
}
		
		

		

		
	


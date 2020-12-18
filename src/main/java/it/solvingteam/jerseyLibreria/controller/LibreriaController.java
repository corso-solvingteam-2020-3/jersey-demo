package it.solvingteam.jerseyLibreria.controller;

import java.util.List;

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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import it.solvingteam.jerseyLibreria.dto.LibreriaDTO;
import it.solvingteam.jerseyLibreria.service.LibreriaService;

@Component
@Path("/api/libreria")
public class LibreriaController {
	
    @Autowired
    private LibreriaService libreriaService;

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @CrossOrigin
    public Response update(LibreriaDTO libreriaDTO) {
    	try {
    		return Response.status(HttpStatus.OK.value()).entity(libreriaService.aggiorna(libreriaDTO)).build();
		} catch (Exception e) {
			return Response.status(HttpStatus.UNPROCESSABLE_ENTITY.value()).entity(e.getMessage()).build();
		}
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @CrossOrigin
    public Response create(LibreriaDTO libreriaDTO) {
    	try {
    		return Response.status(HttpStatus.OK.value()).entity(libreriaService.inserisci(libreriaDTO)).build();
		} catch (Exception e) {
			return Response.status(HttpStatus.UNPROCESSABLE_ENTITY.value()).entity(e.getMessage()).build();
		}
    }
    
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @CrossOrigin
    public Response delete(@PathParam("id") String id) {
    	try {
			libreriaService.delete(id);
			return Response.ok().build();
		} catch (Exception e) {
			return Response.status(HttpStatus.BAD_REQUEST.value()).entity(e.getMessage()).build();
		}
    } 
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @CrossOrigin
    public Response getOne(@PathParam("id") String id) {
    	try {
			return Response.ok().entity(libreriaService.getById(id)).build();
		} catch (Exception e) {
			return Response.status(HttpStatus.BAD_REQUEST.value()).entity(e.getMessage()).build();
		}
    }    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @CrossOrigin
    public Response getAll() {
    	List<LibreriaDTO> resultLibrerieDTO = libreriaService.findAll();
        return Response.ok().entity(resultLibrerieDTO).build();
    }

}

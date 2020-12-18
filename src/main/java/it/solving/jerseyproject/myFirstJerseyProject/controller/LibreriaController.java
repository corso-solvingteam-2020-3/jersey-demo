package it.solving.jerseyproject.myFirstJerseyProject.controller;

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

import it.solving.jerseyproject.myFirstJerseyProject.dto.LibreriaDto;
import it.solving.jerseyproject.myFirstJerseyProject.dto.MessageDto;
import it.solving.jerseyproject.myFirstJerseyProject.service.LibreriaService;

@Component
@Path("/api")
public class LibreriaController {
	
	@Autowired
	private LibreriaService libreriaService;
	
	@GET
	@Path("/libreria")
	@Produces(MediaType.APPLICATION_JSON)
	public List<LibreriaDto> findAllLibreries() {
		
		return libreriaService.listAll();
	}
	
	@GET
	@Path("/libreria/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public LibreriaDto findLibraryById(@PathParam("id") Integer id) {
	
		
		return libreriaService.findById(id);
		
	}
	
	@POST
	@Path("/libreria")
    @Produces(MediaType.APPLICATION_JSON) //endpoint restituisce un json
    @Consumes(MediaType.APPLICATION_JSON) //endpoint lavora su un json
	public Response insertLibrary(LibreriaDto dto){
		try {
			libreriaService.insertLibrary(dto);
			return Response.status(HttpStatus.OK.value()).entity(new MessageDto("Operazione Effettuata con Successo")).build();
		} catch (Exception e) {
			return Response.status(HttpStatus.UNPROCESSABLE_ENTITY.value()).entity(new MessageDto(e.getMessage())).build();
		}
	}
	
	@PUT
	@Path("/libreria")
    @Produces(MediaType.APPLICATION_JSON) //endpoint restituisce un json
    @Consumes(MediaType.APPLICATION_JSON) //endpoint lavora su un json
	public Response updateLibrary(LibreriaDto dto) {
		try {
			libreriaService.updateLibrary(dto);
			return Response.status(HttpStatus.OK.value()).entity(new MessageDto("Operazione Effettuata con Successo")).build();
		} catch (Exception e) {
			return Response.status(HttpStatus.UNPROCESSABLE_ENTITY.value()).entity(new MessageDto(e.getMessage())).build();
		}
	}
	
	@DELETE
	@Path("/libreria/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteLibrary(@PathParam("id") Integer id) {
		libreriaService.deleteLibrary(id);
		return Response.status(HttpStatus.OK.value()).entity(new MessageDto("Operazione effettuata con Successo")).build();
	}

	
	
}

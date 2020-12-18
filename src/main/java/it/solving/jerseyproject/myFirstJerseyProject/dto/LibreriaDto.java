package it.solving.jerseyproject.myFirstJerseyProject.dto;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class LibreriaDto {
	
	@NotNull(message = "id doesn't exist")
	private String id;
	
	@NotEmpty(message = "genere is required")
	private String genere;
	
	@NotEmpty(message = "slot is required")
	private String slot;
	
	@NotEmpty(message = "libri is required")
	private List<String> libri;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	public String getSlot() {
		return slot;
	}

	public void setSlot(String slot) {
		this.slot = slot;
	}

	public List<String> getLibri() {
		return libri;
	}

	public void setLibri(List<String> libri) {
		this.libri = libri;
	}
	
	

}

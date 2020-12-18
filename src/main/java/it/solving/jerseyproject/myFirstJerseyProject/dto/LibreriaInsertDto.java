package it.solving.jerseyproject.myFirstJerseyProject.dto;

import java.util.List;

import javax.validation.constraints.NotEmpty;

public class LibreriaInsertDto {
	
	@NotEmpty(message = "genere is required")
	private String genere;
	
	@NotEmpty(message = "slot is required")
	private String slot;
	
	@NotEmpty(message = "libri is required")
	private List<String> libri;

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

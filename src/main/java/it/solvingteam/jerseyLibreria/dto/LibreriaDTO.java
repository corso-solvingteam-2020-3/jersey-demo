package it.solvingteam.jerseyLibreria.dto;

import java.util.ArrayList;
import java.util.List;

public class LibreriaDTO {

	private String id;
	
	private String genere;
	
	private String slot;
	
	private List<String> libri = new ArrayList<>();

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

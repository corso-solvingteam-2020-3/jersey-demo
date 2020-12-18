package it.solving.jerseyproject.myFirstJerseyProject.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import it.solving.jerseyproject.myFirstJerseyProject.dto.LibreriaDto;
import it.solving.jerseyproject.myFirstJerseyProject.model.Libreria;

@Component
public class LibreriaMapper extends AbstractMapper<Libreria, LibreriaDto>{

	@Override
	public LibreriaDto convertEntityToDto(Libreria entity) {
		
		if (entity == null) {
            return null;
        }
		
		LibreriaDto dto = new LibreriaDto();
		
		dto.setId(String.valueOf(entity.getId()));
		dto.setGenere(entity.getGenere());
		dto.setSlot(String.valueOf(entity.getSlot()));
		
		
		List<String> listaLibri = new ArrayList<>();
		String[] libriLibreria = entity.getLibri().split(";");
		
		for(int i=0; i<libriLibreria.length; i++) {
			listaLibri.add(libriLibreria[i]);
		}
		
		dto.setLibri(listaLibri);
		
		return dto;
		
	}

	@Override
	public Libreria convertDtoToEntity(LibreriaDto dto) {
		
		if (dto == null) {
            return null;
        }
		
		Libreria entity = new Libreria();
		
		if(dto.getId() != null) {
			entity.setId(Integer.valueOf(dto.getId()));
		}
		
		entity.setGenere(dto.getGenere());
		entity.setSlot(Integer.valueOf(dto.getSlot()));
		
		String libri = "";
		List<String> listaLibri = dto.getLibri();
		for(String libro : listaLibri) {
			libri = libri + libro + ";";
		}
		
		entity.setLibri(libri);
		
		return entity;
		
	}

}

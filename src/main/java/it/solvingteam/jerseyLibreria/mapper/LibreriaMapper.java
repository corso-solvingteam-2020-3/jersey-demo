package it.solvingteam.jerseyLibreria.mapper;

import java.util.Arrays;

import org.springframework.stereotype.Component;

import it.solvingteam.jerseyLibreria.dto.LibreriaDTO;
import it.solvingteam.jerseyLibreria.model.Libreria;

@Component
public class LibreriaMapper extends AbstractMapper<Libreria, LibreriaDTO> {

	@Override
	public LibreriaDTO convertEntityToDto(Libreria entity) {
        if (entity == null) {
            return null;
        }

        LibreriaDTO libreriaDTO = new LibreriaDTO();
        libreriaDTO.setId(entity.getId().toString());
        libreriaDTO.setGenere(entity.getGenere());
        libreriaDTO.setSlot(entity.getSlot().toString());
        libreriaDTO.setLibri(Arrays.asList(entity.getLibri().split(";")));
        
        return libreriaDTO;
	}

	@Override
	public Libreria convertDtoToEntity(LibreriaDTO dto) {
        if (dto == null) {
            return null;
        }

        Libreria libreria = new Libreria();

        if (dto.getId() != null) {
        	libreria.setId(Integer.valueOf(dto.getId()));
        }
        
        libreria.setGenere(dto.getGenere());
        libreria.setSlot(Integer.valueOf(dto.getSlot()));
        libreria.setLibri(String.join(";", dto.getLibri()));
        
        return libreria;
	}

}

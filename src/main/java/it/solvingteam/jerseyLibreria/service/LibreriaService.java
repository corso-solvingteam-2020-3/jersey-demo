package it.solvingteam.jerseyLibreria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.solvingteam.jerseyLibreria.dto.LibreriaDTO;
import it.solvingteam.jerseyLibreria.mapper.LibreriaMapper;
import it.solvingteam.jerseyLibreria.model.Libreria;
import it.solvingteam.jerseyLibreria.repository.LibreriaRepository;

@Service
public class LibreriaService {
	
    @Autowired
    private LibreriaRepository libreriaRepository;
    
    @Autowired
    private LibreriaMapper libreriaMapper;
    
    public List<LibreriaDTO> findAll() {
        List<Libreria> allLibrerie = this.libreriaRepository.findAll();
        return libreriaMapper.convertEntityToDto(allLibrerie);
    }
    
    public LibreriaDTO getById(String id) throws Exception {
    	if(id==null || isNaN(id)) {
    		throw new Exception("id non valido");
    	}
    	Libreria l= libreriaRepository.findById(Integer.parseInt(id)).orElse(null);
    	if(l==null) {
    		throw new Exception("Libreria non trovata");
    	}
    	return libreriaMapper.convertEntityToDto(l);
    }
    
    public void delete(String id) throws Exception {
    	LibreriaDTO l = this.getById(id);
    	libreriaRepository.delete(libreriaMapper.convertDtoToEntity(l));
    }

	public LibreriaDTO inserisci(LibreriaDTO libreriaDTO) throws Exception {
		if(libreriaDTO == null || libreriaDTO.getGenere()==null || libreriaDTO.getGenere().isEmpty() || libreriaDTO.getSlot() == null || isNaN(libreriaDTO.getSlot())) {
			throw new Exception("Input non valido");
		}
		
		Integer slot = Integer.parseInt(libreriaDTO.getSlot());
		Integer size = libreriaDTO.getLibri().size();
		if(slot < size)
			throw new Exception("Slot non sufficienti");
		
		return this.getById(libreriaRepository.save(libreriaMapper.convertDtoToEntity(libreriaDTO)).getId().toString());
	}

	public LibreriaDTO aggiorna(LibreriaDTO libreriaDTO) throws Exception {
		this.getById(libreriaDTO.getId());
		return this.inserisci(libreriaDTO);		
	}

	private boolean isNaN(String input) {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException e) {
			return true;
		}
		return false;
	}

}

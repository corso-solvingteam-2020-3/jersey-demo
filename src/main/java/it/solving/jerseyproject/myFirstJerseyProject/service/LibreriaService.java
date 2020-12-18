package it.solving.jerseyproject.myFirstJerseyProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.solving.jerseyproject.myFirstJerseyProject.dto.LibreriaDto;
import it.solving.jerseyproject.myFirstJerseyProject.dto.LibreriaInsertDto;
import it.solving.jerseyproject.myFirstJerseyProject.mapper.LibreriaMapper;
import it.solving.jerseyproject.myFirstJerseyProject.model.Libreria;
import it.solving.jerseyproject.myFirstJerseyProject.repository.LibreriaRepository;

@Service
public class LibreriaService {
	
	@Autowired
	private LibreriaRepository libreriaRepository;
	
	@Autowired
	private LibreriaMapper libreriaMapper;
	
	public List<LibreriaDto> listAll(){
		return libreriaMapper.convertEntityToDto(libreriaRepository.findAll());
	}
	
	public LibreriaDto findById(Integer id) {
		return libreriaMapper.convertEntityToDto(libreriaRepository.findById(id).get());
	}
	
	public void insertLibrary(LibreriaDto dto) throws Exception {
		if(dto.getLibri().size() > Integer.valueOf(dto.getSlot())) {
			throw new Exception("Numero libri maggiore della capacità");
			
		}
		
		libreriaRepository.save(libreriaMapper.convertDtoToEntity(dto));
		return;
	}
	
	public void updateLibrary(LibreriaDto dto) throws Exception {
		if(dto.getLibri().size() > Integer.valueOf(dto.getSlot())) {
			throw new Exception("Numero libri maggiore della capacità");
			
		}
		libreriaRepository.save(libreriaMapper.convertDtoToEntity(dto));
		return;
	}
	
	public void deleteLibrary(Integer id) {
		Libreria libreria = libreriaRepository.findById(id).get();
		libreriaRepository.delete(libreria);
	}

}

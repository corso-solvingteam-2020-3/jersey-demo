package it.solving.jerseyproject.myFirstJerseyProject.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.solving.jerseyproject.myFirstJerseyProject.model.Libreria;

public interface LibreriaRepository extends JpaRepository<Libreria, Integer> {
	
	//listAll delle librerie
	List<Libreria> findAll();
	
	//findById
	Optional<Libreria> findById(Integer id);
	

}

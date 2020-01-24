package fr.solutec.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Fiche;


public interface FicheRepository extends CrudRepository<Fiche, Long>{

	@Query (value= "SELECT f FROM Fiche f")
	public List<Fiche> getFiche();
}
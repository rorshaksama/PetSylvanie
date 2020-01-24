package fr.solutec.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.HistoriqueMessage;

public interface HistoriqueMessageRepository extends CrudRepository<HistoriqueMessage, Long>{
	
	@Query(value= "SELECT h FROM HistoriqueMessage h")
	public List<HistoriqueMessage> getHistoriqueMessage();

}

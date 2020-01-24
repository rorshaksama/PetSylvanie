package fr.solutec.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.HistoriqueGarde;
import fr.solutec.entities.HistoriqueMessage;

public interface HistoriqueGardeRepository extends CrudRepository<HistoriqueGarde, Long> {
	
	@Query(value= "SELECT h FROM HistoriqueGarde h")
	public List<HistoriqueMessage> getHistoriqueGarde();

}
package fr.solutec.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Alerte;

public interface AlerteRepository extends CrudRepository<Alerte, Long>{
	
	@Query(value = "SELECT warn FROM Alerte warn")
	public List<Alerte> getAllAlerte();
}

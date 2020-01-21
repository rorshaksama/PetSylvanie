package fr.solutec.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Alerte;

public interface AlerteRepository extends CrudRepository<Alerte, Long>{
	
	@Query(value= "SELECT al FROM Alerte al WHERE user.id = ?1")
	public List<Alerte> getAlerteById(Long id);
	
	@Query(value= "SELECT al FROM Alerte al")
	public List<Alerte> getAlerte();
}

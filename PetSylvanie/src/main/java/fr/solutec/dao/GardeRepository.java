package fr.solutec.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Garde;

public interface GardeRepository extends CrudRepository<Garde, Long>{

	@Query(value= "SELECT g FROM Garde g")
	public List<Garde> getGarde();
}

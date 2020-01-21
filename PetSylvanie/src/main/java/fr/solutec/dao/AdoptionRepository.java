package fr.solutec.dao;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import fr.solutec.entities.Adoption;


public interface AdoptionRepository extends CrudRepository <Adoption, Long>{
	
	@Query (value= "SELECT a FROM Adoption a")
	public List<Adoption> getAdoption();	
}

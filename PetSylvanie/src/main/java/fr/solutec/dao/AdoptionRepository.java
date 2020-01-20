package fr.solutec.dao;
import org.springframework.data.repository.CrudRepository;
import fr.solutec.entities.Adoption;

public interface AdoptionRepository extends CrudRepository <Adoption, Long>{
	
	

}

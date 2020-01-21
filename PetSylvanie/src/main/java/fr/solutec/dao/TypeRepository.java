package fr.solutec.dao;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import fr.solutec.entities.Type;


public interface TypeRepository extends CrudRepository<Type, Long> {

	@Query(value= "SELECT t FROM Type t")
	public List<Type> getType();
}

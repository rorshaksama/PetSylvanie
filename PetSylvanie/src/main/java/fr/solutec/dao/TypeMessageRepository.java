package fr.solutec.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.TypeMessage;

public interface TypeMessageRepository extends CrudRepository<TypeMessage, Long> {

	@Query(value= "SELECT t FROM Type t")
	public List<TypeMessage> getTypeMessage();
}

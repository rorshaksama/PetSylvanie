package fr.solutec.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import fr.solutec.entities.Message;

public interface MessageRepository extends CrudRepository<Message, Long>{

	@Query(value= "SELECT m FROM Message m")
	public List<Message> getMessage();
	
	
	public List<Message> findByAlerteId(Long id);
}

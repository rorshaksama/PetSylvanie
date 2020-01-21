package fr.solutec.dao;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import fr.solutec.entities.User;



public interface UserRepository extends CrudRepository<User, Long> {

	
	
	@Query(value= "SELECT u FROM User u")
	public List<User> getUser();
}

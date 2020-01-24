package fr.solutec.dao;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.User;



public interface UserRepository extends CrudRepository<User, Long> {

	@Query(value= "SELECT u FROM User u")
	public List<User> getUser();
	
	@Query(value= "SELECT u FROM User u WHERE u.id= ?1")
	public User getUserById();	
	
	public Optional<User> getByLogin(String login);
	
	@Query(value= "UPDATE User u SET u.mail= ?1")
	public User updateUserMail(String mail);
	
	public Optional<User> findByLoginAndMdp(String login, String mdp);
}

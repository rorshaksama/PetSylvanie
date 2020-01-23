package fr.solutec.dao;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import fr.solutec.entities.Animal;
import fr.solutec.entities.User;

public interface AnimalRepository extends CrudRepository<Animal, Long>{

	@Query(value= "SELECT a FROM Animal a WHERE user.id = ?1")
	public List<Animal> getAnimalById(Long id);
	
	@Query(value= "SELECT a FROM Animal a")
	public List<Animal> getAnimal();
	
	public Optional<Animal> getById(Long id);
	
	public Optional<Animal> getByUser(User user);
	
	public Optional<Animal> getByNom(String nom);
}

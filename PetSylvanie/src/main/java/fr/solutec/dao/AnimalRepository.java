package fr.solutec.dao;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import fr.solutec.entities.Animal;

public interface AnimalRepository extends CrudRepository<Animal, Long>{

	@Query(value= "SELECT a FROM Animal a WHERE user.id = ?1")
	public List<Animal> getAnimal(Long id);
}

package fr.solutec.dao;
import org.springframework.data.repository.CrudRepository;
import fr.solutec.entities.Animal;

public interface AnimalRepository extends CrudRepository<Animal, Long>{

}

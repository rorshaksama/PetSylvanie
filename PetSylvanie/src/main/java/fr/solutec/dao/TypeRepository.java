package fr.solutec.dao;
import org.springframework.data.repository.CrudRepository;
import fr.solutec.entities.Type;


public interface TypeRepository extends CrudRepository<Type, Long> {

}

package fr.solutec.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Garde;

public interface GardeRepository extends CrudRepository<Garde, Long>{

	@Query(value= "SELECT g FROM Garde g")
	public List<Garde> getGarde();
	
	@Query(value= "SELECT g FROM Garde g WHERE user_gardien.id = ?1")
	public List<Garde> getGardeByIdGardien(Long id);
	
	@Query(value= "SELECT g FROM Garde g WHERE user_garde.id = ?1")
	public List<Garde> getGardeByIdUserGarde(Long id);
	
	@Query(value= "SELECT g FROM Garde g WHERE animal_garde.id = ?1")
	public List<Garde> getGardeByIdAnimalGarde(Long id);
}

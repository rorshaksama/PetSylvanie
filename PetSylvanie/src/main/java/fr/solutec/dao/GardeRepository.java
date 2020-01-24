package fr.solutec.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Garde;

public interface GardeRepository extends CrudRepository<Garde, Long>{

	@Query(value= "SELECT g FROM Garde g")
	public List<Garde> getGarde();
	
	@Query(value= "SELECT g FROM Garde g WHERE userGardien.id = ?1")
	public List<Garde> getGardeByIdGardien(Long id);
	
	@Query(value= "SELECT g FROM Garde g WHERE animal.id = ?1")
	public List<Garde> getGardeByIdAnimalGarde(Long id);
}

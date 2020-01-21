package fr.solutec.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import fr.solutec.dao.AnimalRepository;
import fr.solutec.entities.Animal;

@RestController @CrossOrigin("*")
public class AnimalRest {

	@Autowired 
	private AnimalRepository animalRepo;
	
	@RequestMapping(value = "/animal/{id}", method = RequestMethod.GET)
	public List<Animal> getAlById(@PathVariable Long id){		
		return animalRepo.getAnimalById(id);
	}
	
	@RequestMapping(value = "/animal", method = RequestMethod.GET)
	public List<Animal> getAn(){		
		return animalRepo.getAnimal();
	}
	
	@RequestMapping(value = "/createAnimal", method = RequestMethod.POST)
	public Animal createAnimal(@RequestBody Animal animal){		
		return animalRepo.save(animal);
	}
	
	@RequestMapping(value = "/animal/{id}", method = RequestMethod.DELETE)
	public void deleteAnimal(@PathVariable Long id){		
		animalRepo.deleteById(id);
	}
}

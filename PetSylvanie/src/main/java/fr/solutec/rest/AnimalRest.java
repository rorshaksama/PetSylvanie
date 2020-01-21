package fr.solutec.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
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
	public List<Animal> getAl(@PathVariable Long id){		
		return animalRepo.getAnimal(id);
	}
}

package fr.solutec.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.dao.AnimalRepository;
import fr.solutec.dao.GardeRepository;
import fr.solutec.dao.UserRepository;
import fr.solutec.entities.Animal;
import fr.solutec.entities.Garde;
import fr.solutec.entities.User;

@RestController @CrossOrigin("*")
public class GardeRest {

	@Autowired 
	private GardeRepository gardeRepo;
	
	@Autowired 
	private AnimalRepository animalRepo;
	
	@Autowired 
	private UserRepository userRepos;
	
	@RequestMapping(value = "/garde", method = RequestMethod.GET)
	public List<Garde> getGar(){		
		return gardeRepo.getGarde();
	}
	
	
	
	@RequestMapping(value = "/garde/fairegarder/{user}", method = RequestMethod.GET)
	public List<Animal> getAnimalById(@PathVariable User user){		
		return animalRepo.getAnimalById(user.getId());
	}
	
	@RequestMapping(value = "/garde", method = RequestMethod.POST)
	public Garde createGarde(@RequestBody Garde garde){	
		/* User userGardien = garde.getUserGardien();
		Animal animal = garde.getAnimal();
		Optional<User> Uexistant = userRepos.getByLogin(userGardien.getLogin());
		Optional<Animal> Aexistant = animalRepo.getById(animal.getId());
		garde.getAnimal().setUser(Uexistant.get());
		garde.setAnimalGarde(Aexistant.get()); */
		return gardeRepo.save(garde);
	}
	
	@RequestMapping(value = "/garde/gardien/{id}", method = RequestMethod.GET)
	public List<Garde> getGarByIdGardien(@PathVariable Long id){		
		return gardeRepo.getGardeByIdGardien(id);
	}
	
	@RequestMapping(value = "/garde/animalGarde/{id}", method = RequestMethod.GET)
	public List<Garde> getGarByIdAnimalGarde(@PathVariable Long id){		
		return gardeRepo.getGardeByIdAnimalGarde(id);
	}
	
	@RequestMapping(value = "/garde/{id}", method = RequestMethod.DELETE)
	public void deleteGarde(@PathVariable Long id){		
		gardeRepo.deleteById(id);
	}
}

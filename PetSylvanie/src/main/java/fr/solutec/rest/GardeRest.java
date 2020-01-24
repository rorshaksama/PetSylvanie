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
	
	@RequestMapping(value = "/createGarde", method = RequestMethod.POST)
	public Garde createGarde(@RequestBody Garde garde){	
		User u = garde.getAnimal().getUser();
		Animal a = garde.getAnimal();
		Optional<User> Uexistant = userRepos.getByLogin(u.getLogin());
		Optional<Animal> Aexistant = animalRepo.getById(a.getId());
		if(!Uexistant.isPresent()) {
			User new_user = userRepos.save(u);
			garde.getAnimal().setUser(new_user);
			Animal new_animal = animalRepo.save(a);
			new_animal.setUser(new_user);
			garde.setAnimalGarde(new_animal);
		}
		else if (Uexistant.isPresent() && !Aexistant.isPresent()) {
			garde.getAnimal().setUser(Uexistant.get()); 
			Animal new_animal = animalRepo.save(a);
			new_animal.setUser(Uexistant.get());
			garde.setAnimalGarde(new_animal);
		}
		else {
			garde.getAnimal().setUser(Uexistant.get());
			garde.setAnimalGarde(Aexistant.get());
		}
		return gardeRepo.save(garde);
	}
	
	@RequestMapping(value = "/garde/gardien/{id}", method = RequestMethod.GET)
	public List<Garde> getGarByIdGardien(@PathVariable Long id){		
		return gardeRepo.getGardeByIdGardien(id);
	}
	
	@RequestMapping(value = "/garde/proprio/{id}", method = RequestMethod.GET)
	public List<Garde> getGarByIdUserProprio(@PathVariable Long id){		
		return gardeRepo.getGardeByIdUserProprio(id);
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

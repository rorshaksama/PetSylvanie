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

import fr.solutec.dao.AdoptionRepository;
import fr.solutec.dao.AnimalRepository;
import fr.solutec.dao.UserRepository;
import fr.solutec.entities.Adoption;
import fr.solutec.entities.Animal;
import fr.solutec.entities.User;

@RestController @CrossOrigin("*")
public class AdoptionRest {

	@Autowired
	private AdoptionRepository adoptionRepo;
	
	@Autowired 
	private AnimalRepository animalRepo;
	
	@Autowired 
	private UserRepository userRepos;
	
	@RequestMapping(value = "/adoption", method = RequestMethod.GET)
	public List<Adoption> getAdop() {
		return adoptionRepo.getAdoption();
	}
	
	@RequestMapping(value = "/createAdoption", method = RequestMethod.POST)
	public Adoption createAdoption(@RequestBody Adoption adoption){		
		User u = adoption.getAnimal().getUser();
		Animal a = adoption.getAnimal();
		Optional<User> Uexistant = userRepos.getByLogin(u.getLogin());
		Optional<Animal> Aexistant = animalRepo.getById(a.getId());
		if(!Uexistant.isPresent()) {
			User new_user = userRepos.save(u);
			adoption.getAnimal().setUser(new_user);
			Animal new_animal = animalRepo.save(a);
			new_animal.setUser(new_user);
			adoption.setAnimal(new_animal);
		}
		else if (Uexistant.isPresent() && !Aexistant.isPresent()) {
			adoption.getAnimal().setUser(Uexistant.get()); 
			Animal new_animal = animalRepo.save(a);
			new_animal.setUser(Uexistant.get());
			adoption.setAnimal(new_animal);
		}
		else {
			adoption.getAnimal().setUser(Uexistant.get());
			adoption.setAnimal(Aexistant.get());
		}
		return adoptionRepo.save(adoption);
	}
	
	@RequestMapping(value = "/adoption/{id}", method = RequestMethod.GET)
	public List<Adoption> getAdopById(@PathVariable Long id){		
		return adoptionRepo.getAdoptionByUserId(id);
	}
	
	@RequestMapping(value = "/adoption/{id}", method = RequestMethod.DELETE)
	public void deleteAdoption(@PathVariable Long id){		
		adoptionRepo.deleteById(id);
	}
	
	
	
	@RequestMapping(value = "/createadptionjo", method = RequestMethod.POST)
	public Adoption createAdoptionJo(@RequestBody Adoption adoption){
		
		User userRecup = adoption.getAnimal().getUser();
		Optional<User> verifUser = userRepos.getByLogin(userRecup.getLogin());
		
		User ultimate = new User();
		Animal finalAnimal = new Animal();
		
		if(verifUser.isPresent()) {
			
			userRecup.setId(verifUser.get().getId());
			ultimate = userRepos.save(userRecup);
			
			Animal animalRecup = adoption.getAnimal();
			Optional<Animal> verifAnimal = animalRepo.getById(animalRecup.getId());
			
			if(verifAnimal.isPresent()) {
				animalRecup.setId(verifAnimal.get().getId());
			}
			else {
				animalRecup.getUser().setId(ultimate.getId());
				animalRepo.save(animalRecup);
			}
		}
		else {
			ultimate = userRepos.save(userRecup);
			adoption.getAnimal().setUser(ultimate);
			finalAnimal = animalRepo.save(adoption.getAnimal());
		}
		adoption.setAnimal(finalAnimal);
		adoption.getAnimal().setUser(ultimate);
		return adoptionRepo.save(adoption);
	}
	
	
	
	@RequestMapping(value = "/createadoptionjo", method = RequestMethod.POST)
	public Adoption createAdoptionJoJo(@RequestBody Adoption adoption){
		
		User userRec = adoption.getAnimal().getUser();
		Animal animalACreer = adoption.getAnimal();
		
		
		Optional<User> verifUser = userRepos.getByLogin(userRec.getLogin());
		if(!verifUser.isPresent()) {
			animalACreer.setUser(userRepos.save(userRec));
		}
		
		
		
		
		Animal animalCreer = animalRepo.save(animalACreer);
		
		adoption.setAnimal(animalCreer);
		return adoptionRepo.save(adoption);
	}
}

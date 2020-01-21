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
import fr.solutec.dao.UserRepository;
import fr.solutec.entities.Adoption;
import fr.solutec.entities.User;

@RestController @CrossOrigin("*")
public class AdoptionRest {

	@Autowired
	private AdoptionRepository adoptionRepo;
	
	@Autowired 
	private UserRepository userRepos;
	
	@RequestMapping(value = "/adoption", method = RequestMethod.GET)
	public List<Adoption> getAdop() {
		return adoptionRepo.getAdoption();
	}
	
	@RequestMapping(value = "/createAdoption", method = RequestMethod.POST)
	public Adoption createAdoption(@RequestBody Adoption adoption){		
		User u = adoption.getUser();
		Optional<User> Uexistant = userRepos.getByLogin(u.getLogin());
		if(!Uexistant.isPresent()) {
			User new_user = userRepos.save(u);
			adoption.setUser(new_user);
		}
		else {
			adoption.setUser(Uexistant.get());
		}
		return adoptionRepo.save(adoption);
	}
	
	@RequestMapping(value = "/adoption/{id}", method = RequestMethod.GET)
	public List<Adoption> getAdopById(@PathVariable Long id){		
		return adoptionRepo.getAdoptionById(id);
	}
	
	@RequestMapping(value = "/adoption/{id}", method = RequestMethod.DELETE)
	public void deleteAdoption(@PathVariable Long id){		
		adoptionRepo.deleteById(id);
	}
}

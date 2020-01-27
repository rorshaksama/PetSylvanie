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

import fr.solutec.dao.AlerteRepository;
import fr.solutec.dao.UserRepository;
import fr.solutec.entities.Alerte;
import fr.solutec.entities.User;


@RestController @CrossOrigin("*")
public class AlerteRest {

	@Autowired 
	private AlerteRepository alerteRepo;
	
	@Autowired 
	private UserRepository userRepos;
	
	@RequestMapping(value = "/alerte/{id}", method = RequestMethod.GET)
	public List<Alerte> getAlById(@PathVariable Long id){		
		return alerteRepo.getAlerteById(id);
	}
	
	@RequestMapping(value = "/alerteUser/{id}", method = RequestMethod.GET)
	public String getUsByAlId(@PathVariable Long id){		
		return alerteRepo.getUserByAlerteId(id);
	}
	
	@RequestMapping(value = "/alerte", method = RequestMethod.GET)
	public List<Alerte> getAl(){		
		return alerteRepo.getAlerte();
	}

	@RequestMapping(value = "/createAlerte", method = RequestMethod.POST)
	public Alerte createAlerte(@RequestBody Alerte alerte){		
		User u = alerte.getUser();
		Optional<User> Uexistant = userRepos.getByLogin(u.getLogin());
		if(!Uexistant.isPresent()) {
			User new_user = userRepos.save(u);
			alerte.setUser(new_user);
		}
		else {
			alerte.setUser(Uexistant.get());
		}
		return alerteRepo.save(alerte);	
	}
	
	@RequestMapping(value = "/alerte/{id}", method = RequestMethod.DELETE)
	public void deleteAlerte(@PathVariable Long id){		
		alerteRepo.deleteById(id);
	}
	
	
	@RequestMapping(value = "/alerte/usercreate/{id}", method = RequestMethod.POST)
	public boolean isCreate(@PathVariable Long id, @RequestBody Alerte alerte){		
		
		if(alerte.getUser().getId() == id) {
			return true;
		}
		else {
			return false;
		}
	}
}

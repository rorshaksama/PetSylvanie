package fr.solutec.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.dao.AlerteRepository;
import fr.solutec.entities.Alerte;


@RestController @CrossOrigin("*")
public class AlerteRest {

	@Autowired 
	private AlerteRepository alerteRepo;
	
	@RequestMapping(value = "/alerte/{id}", method = RequestMethod.GET)
	public List<Alerte> getAlById(@PathVariable Long id){		
		return alerteRepo.getAlerteById(id);
	}
	
	@RequestMapping(value = "/alerte", method = RequestMethod.GET)
	public List<Alerte> getAl(){		
		return alerteRepo.getAlerte();
	}

	@RequestMapping(value = "/createAlerte", method = RequestMethod.POST)
	public Alerte createAlerte(@RequestBody Alerte alerte){		
		return alerteRepo.save(alerte);
	}
	
	@RequestMapping(value = "/person", method = RequestMethod.POST)
	public Alerte saveAlerte(@RequestBody Alerte al){		
		return alerteRepo.save(al);
	}
	
	@RequestMapping(value = "/alerte/{id}", method = RequestMethod.DELETE)
	public void deleteAlerte(@PathVariable Long id){		
		alerteRepo.deleteById(id);
	}
}

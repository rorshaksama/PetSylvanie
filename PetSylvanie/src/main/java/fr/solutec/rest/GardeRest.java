package fr.solutec.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.dao.GardeRepository;
import fr.solutec.entities.Garde;

@RestController @CrossOrigin("*")
public class GardeRest {

	@Autowired 
	private GardeRepository gardeRepo;
	
	@RequestMapping(value = "/garde", method = RequestMethod.GET)
	public List<Garde> getMes(){		
		return gardeRepo.getGarde();
	}
	
	@RequestMapping(value = "/createMessage", method = RequestMethod.POST)
	public Garde createGarde(@RequestBody Garde garde){		
		return gardeRepo.save(garde);
	}
}

package fr.solutec.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
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
	public List<Garde> getGar(){		
		return gardeRepo.getGarde();
	}
	
	@RequestMapping(value = "/createGarde", method = RequestMethod.POST)
	public Garde createGarde(@RequestBody Garde garde){		
		return gardeRepo.save(garde);
	}
	
	@RequestMapping(value = "/garde/gardien/{id}", method = RequestMethod.GET)
	public List<Garde> getGarByIdGardien(@PathVariable Long id){		
		return gardeRepo.getGardeByIdGardien(id);
	}
	
	@RequestMapping(value = "/garde/userGarde/{id}", method = RequestMethod.GET)
	public List<Garde> getGarByIdUserGarde(@PathVariable Long id){		
		return gardeRepo.getGardeByIdUserGarde(id);
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

package fr.solutec.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.dao.AdoptionRepository;
import fr.solutec.entities.Adoption;

@RestController @CrossOrigin("*")
public class AdoptionRest {

	@Autowired
	private AdoptionRepository adoptionRepo;
	
	@RequestMapping(value = "/adoption", method = RequestMethod.GET)
	public List<Adoption> getAdop() {
		return adoptionRepo.getAdoption();
	}
	
	@RequestMapping(value = "/createAdoption", method = RequestMethod.POST)
	public Adoption createAdoption(@RequestBody Adoption adoption){		
		return adoptionRepo.save(adoption);
	}
}

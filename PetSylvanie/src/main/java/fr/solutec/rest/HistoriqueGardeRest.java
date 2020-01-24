package fr.solutec.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.dao.HistoriqueGardeRepository;


@RestController @CrossOrigin("*")
public class HistoriqueGardeRest {

	@Autowired
	private HistoriqueGardeRepository histoGardeRepo;
	
	@RequestMapping(value = "/historiqueGarde", method = RequestMethod.GET)
	public List<fr.solutec.entities.HistoriqueMessage> getMes(){		
		return histoGardeRepo.getHistoriqueGarde();
	}
	@RequestMapping(value = "/historiqueGarde/{id}", method = RequestMethod.DELETE)
	public void deleteAdoption(@PathVariable Long id){		
		histoGardeRepo.deleteById(id);
	}
}
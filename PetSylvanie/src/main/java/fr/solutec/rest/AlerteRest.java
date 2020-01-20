package fr.solutec.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.dao.AlerteRepository;
import fr.solutec.entities.Alerte;

@RestController @CrossOrigin("*")
public class AlerteRest {

	@Autowired 
	private AlerteRepository alerteRepo;
	
	@RequestMapping(value = "/alerte", method = RequestMethod.GET)
	public List<Alerte> getAl(){		
		return alerteRepo.getAlerte();
	}
}

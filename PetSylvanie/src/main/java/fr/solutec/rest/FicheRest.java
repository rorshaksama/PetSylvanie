package fr.solutec.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.dao.FicheRepository;
import fr.solutec.entities.Fiche;


@RestController @CrossOrigin("*")
public class FicheRest {
	
	@Autowired
	private FicheRepository ficheRepo;
	
	@RequestMapping(value = "/fiche", method = RequestMethod.GET)
	public List<Fiche> getFic() {
		return ficheRepo.getFiche();
	}

}
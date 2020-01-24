package fr.solutec.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.dao.HistoriqueMessageRepository;

@RestController @CrossOrigin("*")
public class HistoriqueMessage {
	
	@Autowired
	private HistoriqueMessageRepository histoMessRepo;
	
	@RequestMapping(value = "/historique", method = RequestMethod.GET)
	public List<fr.solutec.entities.HistoriqueMessage> getMes(){		
		return histoMessRepo.getHistoriqueMessage();
	}

}

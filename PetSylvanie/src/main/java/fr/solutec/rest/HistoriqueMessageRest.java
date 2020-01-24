package fr.solutec.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.dao.HistoriqueMessageRepository;
import fr.solutec.entities.HistoriqueMessage;

@RestController @CrossOrigin("*")
public class HistoriqueMessageRest {
	
	@Autowired
	private HistoriqueMessageRepository histoMessRepo;
	
	@RequestMapping(value = "/historique", method = RequestMethod.GET)
	public List<HistoriqueMessage> getHistoMes(){		
		return histoMessRepo.getHistoriqueMessage();
	}

}

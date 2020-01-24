package fr.solutec.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.dao.TypeMessageRepository;
import fr.solutec.entities.TypeMessage;

@RestController @CrossOrigin("*")
public class TypeMessageRest {

	@Autowired
	private TypeMessageRepository typeMessRepo;
	
	@RequestMapping(value = "/typeMessage", method = RequestMethod.GET)
	public List<TypeMessage> getTy() {
		return   (List<TypeMessage>)  typeMessRepo.getTypeMessage();
	}
	
	@RequestMapping(value = "/typeMessage", method = RequestMethod.POST)
	public TypeMessage putTypeMessage(@RequestBody TypeMessage t) {
		return typeMessRepo.save(t);
	}
}

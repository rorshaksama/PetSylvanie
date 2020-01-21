package fr.solutec.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.Type;
import fr.solutec.dao.TypeRepository;

@RestController @CrossOrigin("*")
public class TypeRest {

	@Autowired
	private TypeRepository typeRepo;
	
	@RequestMapping(value = "/type", method = RequestMethod.GET)
	public List<Type> getTy() {
		return   (List<Type>)  typeRepo.getType();
	}
}

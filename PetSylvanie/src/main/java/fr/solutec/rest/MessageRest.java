package fr.solutec.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.dao.MessageRepository;
import fr.solutec.entities.Message;




@RestController @CrossOrigin("*")
public class MessageRest {

	@Autowired 
	private MessageRepository messageRepo;
	
	@RequestMapping(value = "/message", method = RequestMethod.GET)
	public List<Message> getMes(){		
		return messageRepo.getMessage();
	}
	
	@RequestMapping(value = "/createMessage", method = RequestMethod.POST)
	public Message createMessage(@RequestBody Message message){		
		return messageRepo.save(message);
	}
}

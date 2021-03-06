package fr.solutec.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.dao.MessageRepository;
import fr.solutec.dao.UserRepository;
import fr.solutec.entities.Alerte;
import fr.solutec.entities.Message;
import fr.solutec.entities.User;




@RestController @CrossOrigin("*")
public class MessageRest {

	@Autowired 
	private MessageRepository messageRepo;
	
	@Autowired 
	private UserRepository userRepos;
	
	@RequestMapping(value = "/message", method = RequestMethod.GET)
	public List<Message> getMes(){		
		return messageRepo.getMessage();
	}
	
	@RequestMapping(value = "/message", method = RequestMethod.POST)
	public Message createMessage(@RequestBody Message message){	
			User u_ex = message.getUserExpediteur();
			//User u_des = message.getUser_destinataire();
			Optional<User> Uexistant = userRepos.getByLogin(u_ex.getLogin());
			if(!Uexistant.isPresent()) {
				User new_user = userRepos.save(u_ex);
				message.setUserExpediteur(new_user);
			}
			else {
				message.setUserExpediteur(Uexistant.get());
			}
		return messageRepo.save(message);
	}
	
	@RequestMapping(value = "/message/{id}", method = RequestMethod.DELETE)
	public void deleteMessage(@PathVariable Long id){		
		messageRepo.deleteById(id);
	}
	
	@RequestMapping(value = "/message/{id}", method = RequestMethod.GET)
	public Optional<Message> getMessageById(@PathVariable Long id){		
		return messageRepo.findById(id);
	}
	
	
	@RequestMapping(value = "/message/alerte/{id}", method = RequestMethod.GET)
	public List<Message> getMessageByAlerte(@PathVariable Long id){		
		return messageRepo.findByAlerteId(id);
	}
	
	@RequestMapping(value = "/message/nb/alerte/{id}", method = RequestMethod.GET)
	public int getNbMessageByAlerte(@PathVariable Long id){	
		
		List<Message> messages = messageRepo.findByAlerteId(id);
		
		return messages.size();
	}
	
	
	
}

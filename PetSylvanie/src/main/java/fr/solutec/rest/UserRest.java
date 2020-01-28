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


import fr.solutec.dao.UserRepository;
import fr.solutec.entities.User;

@RestController @CrossOrigin("*")
public class UserRest {

	@Autowired 
	private UserRepository userRepo;
	
	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public User createUser(@RequestBody User user){		
		return userRepo.save(user);
	}
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	public User modifUser(@RequestBody User user, @PathVariable Long id){	
		
		Optional<User> umod = userRepo.findById(id);
		
		user.setId(id);
		user.setMdp(umod.get().getMdp());
		return userRepo.save(user);
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public List<User> getUs() {
		return userRepo.getUser();
	}
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public User getUsById() {
		return userRepo.getUserById();
	}
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable Long id){		
		userRepo.deleteById(id);
	}
	
	@RequestMapping(value = "/connexion", method = RequestMethod.POST)
	public User connexion(@RequestBody User u) {
		Optional<User> pe = userRepo.findByLoginAndMdp(u.getLogin(), u.getMdp());
		
		User pp = new User();
		if (pe.isPresent()) {
			pp = pe.get();
			pp.setMdp(null);
		}
		return pp;
	}
}

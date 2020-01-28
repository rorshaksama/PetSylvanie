package fr.solutec;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import fr.solutec.dao.AdoptionRepository;

import fr.solutec.dao.AlerteRepository;

import fr.solutec.dao.AnimalRepository;
import fr.solutec.dao.FicheRepository;
import fr.solutec.dao.GardeRepository;
import fr.solutec.dao.MessageRepository;
import fr.solutec.dao.TypeRepository;
import fr.solutec.dao.UserRepository;

import fr.solutec.entities.Adoption;

import fr.solutec.entities.Alerte;

import fr.solutec.entities.Animal;
import fr.solutec.entities.Fiche;
import fr.solutec.entities.Garde;
import fr.solutec.entities.Message;
import fr.solutec.entities.Type;
import fr.solutec.entities.User;


@SpringBootApplication
public class PetSylvanieApplication extends SpringBootServletInitializer implements CommandLineRunner {
	
	@Autowired 
	private UserRepository userRepo;
	
	@Autowired 
	private AnimalRepository animalRepo;
	
	@Autowired 
	private TypeRepository typeRepo;
	
	@Autowired 
	private AdoptionRepository adoptionRepo;

	@Autowired
	private AlerteRepository alerteRepo;
	
	@Autowired
	private MessageRepository messageRepo;
	
	@Autowired
	private GardeRepository gardeRepo;
	
	@Autowired
	private FicheRepository ficheRepo;
	


	public static void main(String[] args) {
		SpringApplication.run(PetSylvanieApplication.class, args);
		
		System.out.println( "lancement terminé ok");	
	}
		
	@Override
	public void run(String... args) throws Exception {
	   System.out.println("lancement des instructions");
	   
	   Type t1 = new Type("Chien");
	   typeRepo.save(t1);
	   Type t2 = new Type("Chat");
	   typeRepo.save(t2);
	   Type t3 = new Type("Oiseau");
	   typeRepo.save(t3);
	   Type t4 = new Type("Rongeur");
	   typeRepo.save(t4);
	   Type t5 = new Type("Lapin");
	   typeRepo.save(t5);
	   	   
	   User u1 = new User("Verhalle","floflo@wanadoo.fr","Florian","floflo","floflo");
	   userRepo.save(u1);
	   User u2 = new User("Priol","cecethebestdev@laposte.net","Celia","cecedev","cecedev");
	   userRepo.save(u2);
	   User u3 = new User("Marechal","marechaljojo@gmail.com","Jojo","JojoMarech","JojoMarech");
	   userRepo.save(u3);
	   User u4 = new User("Cunat","pullolianmymen@hotmail.com","Florian","flo1","flo1");
	   userRepo.save(u4);
	   User u5 = new User("Varin","varingaet@minesdedouai.fr", "Gaetan","ladygaga","ladygaga");
	   userRepo.save(u5);
	   
	   
DateFormat d = new SimpleDateFormat("dd/MM/yyyy");
	   
d.parse("25/12/2010");


Animal a1 = new Animal("Ouaf", t1 ,"Gentil chien", d.parse("19/6/2014") ,u1);
animalRepo.save(a1);
Animal a2 = new Animal("Mew", t2 ,"Gentil chat", d.parse("06/7/2015") ,u2);
animalRepo.save(a2);
Animal a3 = new Animal("Woody", t3 ,"Gentil oiseau", d.parse("25/01/2017") ,u1);
animalRepo.save(a3);
Animal a4 = new Animal("Stuart", t4 ,"Gentil rongeur", d.parse("02/12/2013") ,u4);
animalRepo.save(a4);
Animal a5 = new Animal("Panpan", t5 ,"Gentil lapin", d.parse("05/02/2014") ,u5);
animalRepo.save(a5);
Animal a6 = new Animal("Garfield", t2 ,"Gentil chat", d.parse("29/10/2015") ,u1);
animalRepo.save(a6);



Adoption ad1 = new Adoption(a1);
adoptionRepo.save(ad1);
Adoption ad2 = new Adoption(a2);
adoptionRepo.save(ad2);

Alerte warn1 = new Alerte(u2, "Petit chat noir perdu dans le 17ème arrondissement, aidez-moi à le retrouver !", d.parse("27/01/2020"));
alerteRepo.save(warn1);
Alerte warn2 = new Alerte(u4, "Ma souris blanche s'est sauvée lors de mon cours de SVT au Collège St Martin. Sauvons Stuart !", d.parse("25/01/2020"));
alerteRepo.save(warn2);
Alerte warn3 = new Alerte(u3, "Chien avec collier retrouvé dans la forêt de la Mare Assse. Son nom est Ouaf, je m'en occupe en attendant que ce petit bout retrouve son maître au plus vite", d.parse("22/01/2020"));
alerteRepo.save(warn3);


Message m1 = new Message(u4, u1, "Stuart est chez moi ! Je te contacte via ton email pour un rendez vous");
m1.setAlerte(warn2);
messageRepo.save(m1); 
Message m2 = new Message(u3, u1, "Ouaf ! Mon toutou ! Papa est là, j'arrive !");
m2.setAlerte(warn3);
messageRepo.save(m2);
	   

Garde g2 = new Garde("Chat trop choupi tout mignon cherche maître pour un soir ce samedi", u2, a2, d.parse("01/02/2020"), d.parse("02/02/2020") );
gardeRepo.save(g2);

Garde g1 = new Garde("Cherche dogsitter pour vendredi après midi", u1, a2, d.parse("31/01/2020"), d.parse("31/01/2020") );
gardeRepo.save(g1);

	  
}
}

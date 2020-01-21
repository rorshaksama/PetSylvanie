package fr.solutec;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import fr.solutec.dao.AdoptionRepository;

import fr.solutec.dao.AlerteRepository;

import fr.solutec.dao.AnimalRepository;
import fr.solutec.dao.MessageRepository;
import fr.solutec.dao.TypeRepository;
import fr.solutec.dao.UserRepository;

import fr.solutec.entities.Adoption;

import fr.solutec.entities.Alerte;

import fr.solutec.entities.Animal;
import fr.solutec.entities.Message;
import fr.solutec.entities.Type;
import fr.solutec.entities.User;


@SpringBootApplication
public class PetSylvanieApplication implements CommandLineRunner {
	
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
	   
	   User u1 = new User("floflo","flo@gmail.com","floflo2","Florian","Vava");
	   userRepo.save(u1);
	   User u2 = new User("t1","test1@mail.com","t1","test1","test1");
	   userRepo.save(u2);
	   User u3 = new User("Jojo","jojo@gmail.com","Maréchal","joel","Jojo");
	   userRepo.save(u3);
	   User u4 = new User("test2","test2@gmail.com","test2","test","test");
	   userRepo.save(u4);
	   User u5 = new User("Célia","cece@gmail.com","Cece2","Célia","Dev");
	   userRepo.save(u5);
	   
	   DateFormat d = new SimpleDateFormat("dd/MM/yyyy");
	   
	   d.parse("25/12/2010");
	   
	   Animal a1 = new Animal("Tigrou", t1 ,"Gentil chat", d.parse("25/12/2010") ,u1);
	   animalRepo.save(a1);
	   Animal a2 = new Animal("Iolo", t2 ,"Gentil rongeur", d.parse("25/12/2010") ,u2);
	   animalRepo.save(a2);
	   Animal a3 = new Animal("Igloo", t3 ,"Gentil lapin", d.parse("25/12/2010") ,u3);
	   animalRepo.save(a3);
	   Animal a4 = new Animal("Marco", t4 ,"Gentil chien", d.parse("25/12/2010") ,u4);
	   animalRepo.save(a4);
	   Animal a5 = new Animal("Jean", t5 ,"Gentil c", d.parse("25/12/2010") ,u5);
	   animalRepo.save(a5);
	   

	   Adoption ad1 = new Adoption(u1,a1);
	   adoptionRepo.save(ad1);
	   Adoption ad2 = new Adoption(u2,a2);
	   adoptionRepo.save(ad2);

	   Alerte warn1 = new Alerte(u1, "Petit chat perdu et tout mignon", d.parse("15/02/2019"));
	   alerteRepo.save(warn1);
	   Alerte warn2 = new Alerte(u4, "Petit chien perdu et blessé ...", d.parse("25/06/2018"));
	   alerteRepo.save(warn2);
	   Alerte warn3 = new Alerte(u5, "Lapin trop doux et tout mignon perdu dans le bois de Boulogne", d.parse("14/07/2019"));
	   alerteRepo.save(warn3);

	   Message m1 = new Message(u1, u4, "He coucou toi");
	   messageRepo.save(m1);
	   
}
}
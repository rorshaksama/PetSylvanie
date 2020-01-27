package fr.solutec.entities;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
public class Animal {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long id;
	private String nom;
	
	@ManyToOne
	private Type type;
	
	private String description;
	
	@Temporal(TemporalType.DATE)
	private Date dateDeNaissance;
	
	private String photoAnimal;
	
	@ManyToOne
	private User user;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}
	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getPhotoAnimal() {
		return photoAnimal;
	}
	public void setPhotoAnimal(String photoAnimal) {
		this.photoAnimal = photoAnimal;
	}
	public Animal(Long id, String nom, Type type, String description, Date dateDeNaissance, User user) {
		super();
		this.id = id;
		this.nom = nom;
		this.type = type;
		this.description = description;
		this.dateDeNaissance = dateDeNaissance;
		this.user = user;
	}
	public Animal(String nom, Type type, String description, Date dateDeNaissance, User user) {
		super();
		this.nom = nom;
		this.type = type;
		this.description = description;
		this.dateDeNaissance = dateDeNaissance;
		this.user = user;
	}
	public Animal() {
		super();
	}
	public Animal(Long id, String nom, Type type, String description, Date dateDeNaissance, String photoAnimal,
			User user) {
		super();
		this.id = id;
		this.nom = nom;
		this.type = type;
		this.description = description;
		this.dateDeNaissance = dateDeNaissance;
		this.photoAnimal = photoAnimal;
		this.user = user;
	}

	
	
}

package fr.solutec.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Adoption {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Animal animal;
	
	public Long getId() {
		return id;
	}
	
	public Adoption() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Adoption(User user, Animal animal) {
		super();
		this.user = user;
		this.animal = animal;
	}

	public Adoption(Long id, User user, Animal animal) {
		super();
		this.id = id;
		this.user = user;
		this.animal = animal;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	@Override
	public String toString() {
		return "Adoption [id=" + id + ", user=" + user + ", animal=" + animal + "]";
	}

	
	
	
	
	
}

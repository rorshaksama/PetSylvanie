package fr.solutec.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Adoption {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Animal animal;
	
	private String contenu;
	
	public Long getId() {
		return id;
	}
	
	public Adoption() {
		// TODO Auto-generated constructor stub
	}
	
	
	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public Adoption(Animal animal, String contenu) {
		super();
		this.animal = animal;
		this.contenu = contenu;
	}

	public Adoption(Long id, Animal animal, String contenu) {
		super();
		this.id = id;
		this.animal = animal;
		this.contenu = contenu;
	}

	public Adoption(Animal animal) {
		super();
		this.animal = animal;
	}

	public Adoption(Long id, Animal animal) {
		super();
		this.id = id;
		this.animal = animal;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	@Override
	public String toString() {
		return "Adoption [id=" + id +  ", animal=" + animal + ", contenu=" + contenu + "]";
	}

	

	
	
	
	
	
}

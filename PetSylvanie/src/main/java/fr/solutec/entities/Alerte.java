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
public class Alerte {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Animal animal;
	
	private String message;
	
	@Temporal(TemporalType.DATE)
	private Date dateDisparition;

	public Alerte(Long id, Animal animal, String message, Date dateDisparition) {
		super();
		this.id = id;
		this.animal = animal;
		this.message = message;
		this.dateDisparition = dateDisparition;
	}

	public Alerte(Animal animal, String message, Date dateDisparition) {
		super();
		this.animal = animal;
		this.message = message;
		this.dateDisparition = dateDisparition;
	}


	public Alerte() {
		super();
	}

	public Long getId() {
		return id;
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDateDisparition() {
		return dateDisparition;
	}

	public void setDateDisparition(Date dateDisparition) {
		this.dateDisparition = dateDisparition;
	}

	@Override
	public String toString() {
		return "Alerte [animal=" + animal + ", message=" + message + ", dateDisparition=" + dateDisparition + "]";
	}

	
	
	
}

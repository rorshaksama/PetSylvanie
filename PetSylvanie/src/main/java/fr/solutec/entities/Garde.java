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
public class Garde {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long id;
	
	private String contenu;
	
	@ManyToOne
	private User userGardien;
	
	@ManyToOne
	private User userGarde;
	
	@ManyToOne
	private Animal animal;
	
	@Temporal(TemporalType.DATE)
	private Date dateDébut;
	
	@Temporal(TemporalType.DATE)
	private Date dateFin;

	
	
	public Garde() {
		super();
	}

	public Garde(Long id, String contenu, User userGardien, User userGarde, Animal animal, Date dateDébut,
			Date dateFin) {
		super();
		this.id = id;
		this.contenu = contenu;
		this.userGardien = userGardien;
		this.userGarde = userGarde;
		this.animal = animal;
		this.dateDébut = dateDébut;
		this.dateFin = dateFin;
	}

	public Garde(String contenu, User userGardien, User userGarde, Animal animal, Date dateDébut,
			Date dateFin) {
		super();
		this.contenu = contenu;
		this.userGardien = userGardien;
		this.userGarde = userGarde;
		this.animal = animal;
		this.dateDébut = dateDébut;
		this.dateFin = dateFin;
	}

	public Garde(String contenu, User userGardien, User userGarde, Date dateDébut, Date dateFin) {
		super();
		this.contenu = contenu;
		this.userGardien = userGardien;
		this.userGarde = userGarde;
		this.dateDébut = dateDébut;
		this.dateFin = dateFin;
	}

	public Garde( String contenu, User userGarde, Animal animal, Date dateDébut, Date dateFin) {
		super();
		this.contenu = contenu;
		this.userGarde = userGarde;
		this.animal = animal;
		this.dateDébut = dateDébut;
		this.dateFin = dateFin;
	}

	public Garde(Long id, String contenu, User userGardien, Date dateDébut, Date dateFin) {
		super();
		this.id = id;
		this.contenu = contenu;
		this.userGardien = userGardien;
		this.dateDébut = dateDébut;
		this.dateFin = dateFin;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public User getUserGardien() {
		return userGardien;
	}

	public void setUserGardien(User userGardien) {
		this.userGardien = userGardien;
	}

	public User getUserGarde() {
		return userGarde;
	}

	public void setUserGarde(User userGarde) {
		this.userGarde = userGarde;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimalGarde(Animal animal) {
		this.animal = animal;
	}

	public Date getDateDébut() {
		return dateDébut;
	}

	public void setDateDébut(Date dateDébut) {
		this.dateDébut = dateDébut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	@Override
	public String toString() {
		return "Garde [id=" + id + ", contenu=" + contenu + ", userGardien=" + userGardien + ", userGarde="
				+ userGarde + ", animal=" + animal + ", dateDébut=" + dateDébut + ", dateFin=" + dateFin
				+ "]";
	}
	
	
}

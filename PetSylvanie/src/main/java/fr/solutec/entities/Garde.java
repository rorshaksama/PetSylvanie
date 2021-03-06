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
	private Animal animal;
	
	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	
	@Temporal(TemporalType.DATE)
	private Date dateFin;
		
	public Garde() {
		super();
	}

	public Garde(Long id, String contenu, User userGardien, Animal animal, Date dateDébut,
			Date dateFin) {
		super();
		this.id = id;
		this.contenu = contenu;
		this.userGardien = userGardien;
		this.animal = animal;
		this.dateDebut = dateDébut;
		this.dateFin = dateFin;
	}

	public Garde(String contenu, User userGardien, Animal animal, Date dateDébut,
			Date dateFin) {
		super();
		this.contenu = contenu;
		this.userGardien = userGardien;
		this.animal = animal;
		this.dateDebut = dateDébut;
		this.dateFin = dateFin;
	}

	public Garde( String contenu, Animal animal, Date dateDébut, Date dateFin) {
		super();
		this.contenu = contenu;
		this.animal = animal;
		this.dateDebut = dateDébut;
		this.dateFin = dateFin;
	}

	public Garde(Long id, String contenu, User userGardien, Date dateDébut, Date dateFin) {
		super();
		this.id = id;
		this.contenu = contenu;
		this.userGardien = userGardien;
		this.dateDebut = dateDébut;
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

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimalGarde(Animal animal) {
		this.animal = animal;
	}

	public Date getDateDébut() {
		return dateDebut;
	}

	public void setDateDébut(Date dateDébut) {
		this.dateDebut = dateDébut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	@Override
	public String toString() {
		return "Garde [id=" + id + ", contenu=" + contenu + ", userGardien=" + userGardien + 
				", animal=" + animal + ", dateDébut=" + dateDebut + ", dateFin=" + dateFin + "]";
	}
		
}

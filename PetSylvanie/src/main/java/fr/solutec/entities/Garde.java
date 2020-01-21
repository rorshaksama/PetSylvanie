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
	private User user_gardien;
	
	@ManyToOne
	private User user_garde;
	
	@ManyToOne
	private Animal animal_garde;
	
	@Temporal(TemporalType.DATE)
	private Date dateDébut;
	
	@Temporal(TemporalType.DATE)
	private Date dateFin;

	
	
	public Garde() {
		super();
	}

	public Garde(Long id, String contenu, User user_gardien, User user_garde, Animal animal_garde, Date dateDébut,
			Date dateFin) {
		super();
		this.id = id;
		this.contenu = contenu;
		this.user_gardien = user_gardien;
		this.user_garde = user_garde;
		this.animal_garde = animal_garde;
		this.dateDébut = dateDébut;
		this.dateFin = dateFin;
	}

	public Garde(String contenu, User user_gardien, User user_garde, Animal animal_garde, Date dateDébut,
			Date dateFin) {
		super();
		this.contenu = contenu;
		this.user_gardien = user_gardien;
		this.user_garde = user_garde;
		this.animal_garde = animal_garde;
		this.dateDébut = dateDébut;
		this.dateFin = dateFin;
	}

	public Garde(String contenu, User user_gardien, User user_garde, Date dateDébut, Date dateFin) {
		super();
		this.contenu = contenu;
		this.user_gardien = user_gardien;
		this.user_garde = user_garde;
		this.dateDébut = dateDébut;
		this.dateFin = dateFin;
	}

	public Garde( String contenu, User user_garde, Animal animal_garde, Date dateDébut, Date dateFin) {
		super();
		this.contenu = contenu;
		this.user_garde = user_garde;
		this.animal_garde = animal_garde;
		this.dateDébut = dateDébut;
		this.dateFin = dateFin;
	}

	public Garde(Long id, String contenu, User user_gardien, Date dateDébut, Date dateFin) {
		super();
		this.id = id;
		this.contenu = contenu;
		this.user_gardien = user_gardien;
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

	public User getUser_gardien() {
		return user_gardien;
	}

	public void setUser_gardien(User user_gardien) {
		this.user_gardien = user_gardien;
	}

	public User getUser_garde() {
		return user_garde;
	}

	public void setUser_gardé(User user_garde) {
		this.user_garde = user_garde;
	}

	public Animal getAnimal_garde() {
		return animal_garde;
	}

	public void setAnimal_gardé(Animal animal_garde) {
		this.animal_garde = animal_garde;
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
		return "Garde [id=" + id + ", contenu=" + contenu + ", user_gardien=" + user_gardien + ", user_garde="
				+ user_garde + ", animal_garde=" + animal_garde + ", dateDébut=" + dateDébut + ", dateFin=" + dateFin
				+ "]";
	}
	
	
}

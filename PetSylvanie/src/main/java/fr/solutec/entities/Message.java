package fr.solutec.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Message {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private User userDestinataire;
	
	@ManyToOne
	private User userExpediteur;
	
	@ManyToOne
	private TypeMessage type;
	
	@ManyToOne
	private Alerte alerte;
	
	private String contenu;

	public Message() {
		super();
	}
	
	public Message(Long id, User userDestinataire, User userExpediteur, TypeMessage type, String contenu) {
		super();
		this.id = id;
		this.userDestinataire = userDestinataire;
		this.userExpediteur = userExpediteur;
		this.type = type;
		this.contenu = contenu;
	}

	public Message(Long id, User userDestinataire, User userExpediteur, String contenu) {
		super();
		this.id = id;
		this.userDestinataire = userDestinataire;
		this.userExpediteur = userExpediteur;
		this.contenu = contenu;
	}

	public Message(User userDestinataire, User userExpediteur, String contenu) {
		super();
		this.userDestinataire = userDestinataire;
		this.userExpediteur = userExpediteur;
		this.contenu = contenu;
	}

	public Long getId() {
		return id;
	}
	
	

	public TypeMessage getType() {
		return type;
	}

	public void setType(TypeMessage type) {
		this.type = type;
	}

	public Alerte getAlerte() {
		return alerte;
	}

	public void setAlerte(Alerte alerte) {
		this.alerte = alerte;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUserDestinataire() {
		return userDestinataire;
	}

	public void setUserDestinataire(User userDestinataire) {
		this.userDestinataire = userDestinataire;
	}

	public User getUserExpediteur() {
		return userExpediteur;
	}

	public void setUserExpediteur(User userExpediteur) {
		this.userExpediteur = userExpediteur;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", userDestinataire=" + userDestinataire + ", userExpediteur=" + userExpediteur
				+ ", contenu=" + contenu + "]";
	}
	
	
}

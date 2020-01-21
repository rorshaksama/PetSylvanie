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
	private User user_destinataire;
	
	@ManyToOne
	private User user_expediteur;
	
	private String contenu;

	public Message() {
		super();
	}

	public Message(Long id, User user_destinataire, User user_expediteur, String contenu) {
		super();
		this.id = id;
		this.user_destinataire = user_destinataire;
		this.user_expediteur = user_expediteur;
		this.contenu = contenu;
	}

	public Message(User user_destinataire, User user_expediteur, String contenu) {
		super();
		this.user_destinataire = user_destinataire;
		this.user_expediteur = user_expediteur;
		this.contenu = contenu;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser_destinataire() {
		return user_destinataire;
	}

	public void setUser_destinataire(User user_destinataire) {
		this.user_destinataire = user_destinataire;
	}

	public User getUser_expediteur() {
		return user_expediteur;
	}

	public void setUser_expediteur(User user_expediteur) {
		this.user_expediteur = user_expediteur;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", user_destinataire=" + user_destinataire + ", user_expediteur=" + user_expediteur
				+ ", contenu=" + contenu + "]";
	}
	
	
}

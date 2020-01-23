package fr.solutec.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity 
public class User {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long id;
	private String nom;
	private String prenom;	
	private String login;
	private String mdp;
	private String mail;
	
	public User() {
		super();
	}
	
	

	public User(String login, String mail) {
		super();
		this.login = login;
		this.mail = mail;
	}



	public User(Long id, String nom, String mail, String prenom, String login, String mdp) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.mdp = mdp;
		this.mail = mail;
	}

	public User(String nom, String mail, String prenom, String login, String mdp) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.mdp = mdp;
		this.mail = mail;
	}

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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", login=" + login + ", mdp=" + mdp
				+ ", mail=" + mail + "]";
	}
	
	
}

package fr.solutec.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Fiche {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Type type;
	
	private String titre;
	private String contenu;
	
	
	public Fiche() {
		super();
	}
	public Fiche(Long id, Type type, String titre, String contenu) {
		super();
		this.id = id;
		this.type = type;
		this.titre = titre;
		this.contenu = contenu;
	}
	public Fiche(Type type, String titre, String contenu) {
		super();
		this.type = type;
		this.titre = titre;
		this.contenu = contenu;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	@Override
	public String toString() {
		return "Fiche [id=" + id + ", type=" + type + ", titre=" + titre + ", contenu=" + contenu + "]";
	}	
}

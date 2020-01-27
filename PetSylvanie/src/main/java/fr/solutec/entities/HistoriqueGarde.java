package fr.solutec.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class HistoriqueGarde {


	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	private Garde garde;
	
	@OneToOne
	private Message message;
	
	@CreationTimestamp
	private Date dateCreat;

	public HistoriqueGarde() {
		super();
	}

	
	public HistoriqueGarde(Garde garde, Message message, Date dateCreat) {
		super();
		this.garde = garde;
		this.message = message;
		this.dateCreat = dateCreat;
	}


	public HistoriqueGarde(Long id, Garde garde, Message message, Date dateCreat) {
		super();
		this.id = id;
		this.garde = garde;
		this.message = message;
		this.dateCreat = dateCreat;
	}


	public HistoriqueGarde(Long id, Garde garde, Date dateCreat) {
		super();
		this.id = id;
		this.garde = garde;
		this.dateCreat = dateCreat;
	}

	public HistoriqueGarde(Garde garde, Date dateCreat) {
		super();
		this.garde = garde;
		this.dateCreat = dateCreat;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Garde getGarde() {
		return garde;
	}

	public void setGarde(Garde garde) {
		this.garde = garde;
	}
	
	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public Date getDateCreat() {
		return dateCreat;
	}

	public void setDateCreat(Date dateCreat) {
		this.dateCreat = dateCreat;
	}

	@Override
	public String toString() {
		return "HistoriqueGarde [id=" + id + ", garde=" + garde + ", message=" + message + ", dateCreat=" + dateCreat
				+ "]";
	}	
}
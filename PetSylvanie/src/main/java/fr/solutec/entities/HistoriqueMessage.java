package fr.solutec.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class HistoriqueMessage {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	private Message message;
	
	@CreationTimestamp
	private Date dateCreat;

	public HistoriqueMessage(Long id, Message message, Date dateCreat) {
		super();
		this.id = id;
		this.message = message;
		this.dateCreat = dateCreat;
	}

	public HistoriqueMessage() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		return "HistoriqueMessage [id=" + id + ", message=" + message + ", dateCreat=" + dateCreat + "]";
	}
	
	
}

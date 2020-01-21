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
	private User user;
	
	private String message;
	
	@Temporal(TemporalType.DATE)
	private Date dateDisparition;

	public Alerte(Long id, User user, String message, Date dateDisparition) {
		super();
		this.id = id;
		this.user = user;
		this.message = message;
		this.dateDisparition = dateDisparition;
	}

	public Alerte(User user, String message, Date dateDisparition) {
		super();
		this.user = user;
		this.message = message;
		this.dateDisparition = dateDisparition;
	}

	

	public Alerte(User user, String message) {
		super();
		this.user = user;
		this.message = message;
	}

	
	public Alerte(String message) {
		super();
		this.message = message;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
		return "Alerte [user=" + user + ", message=" + message + ", dateDisparition=" + dateDisparition + "]";
	}

	
	
	
}

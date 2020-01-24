package fr.solutec.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TypeMessage {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long id;
	private String type;
	
	public TypeMessage(String type) {
		super();
		this.type = type;
	}
	
	public TypeMessage() {
		super();
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "TypeMessage [id=" + id + ", type=" + type + "]";
	}
	
}

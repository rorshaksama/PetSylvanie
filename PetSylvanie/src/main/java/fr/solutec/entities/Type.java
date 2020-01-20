package fr.solutec.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity 
public class Type {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long id;
	private String type;
	
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
	public Type(Long id, String type) {
		super();
		this.id = id;
		this.type = type;
	}
	public Type(String type) {
		super();
		this.type = type;
	}
	public Type() {
		super();
	}
	@Override
	public String toString() {
		return "Type [id=" + id + ", type=" + type + "]";
	}

	
}

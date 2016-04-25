package com.iotek.association.one2one.pojo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_passport")
public class Passport implements Serializable {
	private Long id;
	private String bh;
	private Person person;
	
	public Passport(){}

	public Passport(Long id, String bh, Person person) {
		super();
		this.id = id;
		this.bh = bh;
		this.person = person;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBh() {
		return bh;
	}

	public void setBh(String bh) {
		this.bh = bh;
	}

	@OneToOne
	@JoinColumn(name="person_id",unique=true)
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "Passport [bh=" + bh + ", id=" + id + "]";
	}
	
	
	
}

package com.iotek.association.one2one.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_person")
public class Person implements java.io.Serializable{
	private Long id;
	private String name;
	private String gender;
	private Integer age;
	private Passport passport;
	
	public Person(){}

	public Person(Long id, String name, String gender, Integer age, Passport passport) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.passport = passport;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@OneToOne(mappedBy="person",cascade=CascadeType.ALL)
	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	@Override
	public String toString() {
		return "Person [age=" + age + ", gender=" + gender + ", id=" + id
				+ ", name=" + name + ", passport=" + passport + "]";
	}
	
	
	
}

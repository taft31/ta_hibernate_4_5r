package com.iotek.association.many2many.pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="t_technology")
public class Technology implements Serializable {
	private Long id;
	private String name;
	private String category;
	private Set<Engineer> engineers = new HashSet<Engineer>();
		
	public Technology(){}

	public Technology(Long id, String name, String category,
			Set<Engineer> engineers) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.engineers = engineers;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@ManyToMany(mappedBy="technologies")
	public Set<Engineer> getEngineers() {
		return engineers;
	}

	public void setEngineers(Set<Engineer> engineers) {
		this.engineers = engineers;
	}

	@Override
	public String toString() {
		return "Technology [category=" + category + ", engineers=" + engineers
				+ ", id=" + id + ", name=" + name + "]";
	}

	
	
	
}

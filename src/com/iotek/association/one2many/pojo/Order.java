package com.iotek.association.one2many.pojo;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="t_order")
public class Order implements Serializable {
	private Long id;
	private Date orderedDate;
	private Date shippedDate;
	private Double total;
	private Set<OrderLine> orderlines = new HashSet<OrderLine>();
	
	public Order(){}

	public Order(Long id, Date orderedDate, Date shippedDate, Double total,
			Set<OrderLine> orderlines) {
		super();
		this.id = id;
		this.orderedDate = orderedDate;
		this.shippedDate = shippedDate;
		this.total = total;
		this.orderlines = orderlines;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="ordered_date")
	public Date getOrderedDate() {
		return orderedDate;
	}

	public void setOrderedDate(Date orderedDate) {
		this.orderedDate = orderedDate;
	}

	@Column(name="shipped_date")
	public Date getShippedDate() {
		return shippedDate;
	}

	public void setShippedDate(Date shippedDate) {
		this.shippedDate = shippedDate;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	@OneToMany(mappedBy="order",cascade=CascadeType.ALL)
	public Set<OrderLine> getOrderlines() {
		return orderlines;
	}

	public void setOrderlines(Set<OrderLine> orderlines) {
		this.orderlines = orderlines;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderedDate=" + orderedDate
				+ ", orderlines=" + orderlines + ", shippedDate=" + shippedDate
				+ ", total=" + total + "]";
	}

	
	
}

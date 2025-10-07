package com.model;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Bill {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer billno;
	private Date billdate;
	
	public int getBillno() {
		return billno;
	}

	public void setBillno(int billno) {
		this.billno = billno;
	}

	public Date getBilldate() {
		return billdate;
	}

	public void setBilldate(Date billdate) {
		this.billdate = billdate;
	}

	//Mapping Bills to Items
	@ManyToMany
    @JoinTable(
        name = "bill_item",
        joinColumns = @JoinColumn(name = "billno"),
        inverseJoinColumns = @JoinColumn(name = "itemno")
    )
    private List<Item> items;
	
	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	//Mapping Bills to User
	@ManyToOne
	@JoinColumn(name="userid")
	User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user=user;
	}	
	
}

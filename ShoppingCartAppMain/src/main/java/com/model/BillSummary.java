package com.model;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Entity;

public class BillSummary {
	private Integer billno;
	private Date billDate;
	private String username;
	private List<String> itemdesc;
	private List<Integer> itemprice;
	
	public BillSummary() {
		
	}
	public BillSummary(Integer billno, Date billDate, String username, List<String> itemdesc, List<Integer> itemprice) {
		
		this.billno = billno;
		this.billDate=billDate;
		this.username = username;
		this.itemdesc = itemdesc;
		this.itemprice = itemprice;
	}
	public Integer getBillno() {
		return billno;
	}
	public void setBillno(Integer billno) {
		this.billno = billno;
	}
	
	public Date getBillDate() {
		return billDate;
	}
	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public List<String> getItemdesc() {
		return itemdesc;
	}
	public void setItemdesc(List<String> itemdesc) {
		this.itemdesc = itemdesc;
	}
	public List<Integer> getItemprice() {
		return itemprice;
	}
	public void setItemprice(List<Integer> itemprice) {
		this.itemprice = itemprice;
	}
	
	
	
	
	
}

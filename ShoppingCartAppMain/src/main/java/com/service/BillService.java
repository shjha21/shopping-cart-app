package com.service;

import java.util.List;

import com.model.Bill;
import com.model.BillSummary;

public interface BillService {	
	public BillSummary fetchBillSummary(Bill bill);
	public void insert(Bill bill);
}

package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Bill;
import com.model.BillSummary;
import com.model.Item;
import com.repository.BillRepo;

@Service
public class BillServiceImpl implements BillService{
	@Autowired
	BillRepo billRepo;

	@Override
	public BillSummary fetchBillSummary(Bill bill) {
		BillSummary summary = new BillSummary();

	    summary.setBillno(bill.getBillno());
	    summary.setBillDate(bill.getBilldate());
	    summary.setUsername(bill.getUser().getUsername());

	    List<String> itemdescs = new ArrayList<>();
	    List<Integer> itemprices = new ArrayList<>();

	    for (Item item : bill.getItems()) {
	        itemdescs.add(item.getItemdesc());
	        itemprices.add(item.getItemprice());
	    }

	    summary.setItemdesc(itemdescs);
	    summary.setItemprice(itemprices);
	    
	    return summary;
	}
	

	@Override
	public void insert(Bill bill) {
		billRepo.save(bill);
	}
	
	
	
	
}

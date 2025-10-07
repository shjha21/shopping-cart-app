package com.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.model.Bill;
import com.model.BillSummary;
import com.model.Item;

@Repository
public interface BillRepo extends JpaRepository<Bill, Integer>{
//	@Query("SELECT new BillSummary(b.billno+u.username+i.itemdesc+i.itemprice)"
//			+ "FROM Bill b"
//			+ "JOIN b.user u"
//			+ "JOIN b.item i")
//	List<BillSummary> fetchBillSummary();
		
}

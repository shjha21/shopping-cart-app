package com.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.model.Bill;
import com.model.BillSummary;
import com.model.User;
import com.service.BillServiceImpl;
import com.service.ItemServiceImpl;
import com.service.UserServiceImpl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.server.PathParam;

@Controller
@RequestMapping("shop")
public class ShoppingController {
	@Autowired
	private BillServiceImpl billService;
	@Autowired
	private UserServiceImpl userService;
	@Autowired
	private ItemServiceImpl itemService;
	
	@PostMapping("/{id}")
	public ModelAndView loadShoppingForm(
			HttpServletRequest req,
			@PathVariable("id") String id
			) {
		
		System.out.println("ID....."+ id);
		

		ModelAndView mandv=new ModelAndView();
		
		HttpSession session = req.getSession();
		Enumeration<String> e = req.getParameterNames();
		while (e.hasMoreElements()) {
			String name = e.nextElement();
			String value = req.getParameter(name);
			session.setAttribute(name, value);
		}
		if(id.equals("invoice")) {
			return loadInvoice(req, session);
		}
		
		mandv.setViewName("shop"+id);
		return mandv;
	}
	
	public ModelAndView loadInvoice(HttpServletRequest req, HttpSession se) {
		System.out.println("Invoice being loaded..");
		List<String> itemList = new ArrayList();
		Enumeration<String> e = se.getAttributeNames();
		while (e.hasMoreElements()) {
			
			String name = e.nextElement();
			if(name.charAt(0)=='c') {
				String value = se.getAttribute(name).toString();
				System.out.println(value);
				itemList.add(value);
			}
			
		}
		
		Bill bill=new Bill();
		
//		for(String i:itemList) {
			
		bill.setUser(userService.getUser(se.getAttribute("username").toString()));
		bill.setItems(itemService.getItems(itemList));
		bill.setBilldate(Date.valueOf(LocalDate.now()));
		billService.insert(bill);
//		}
//			
		BillSummary summary = billService.fetchBillSummary(bill);
		
		
		ModelAndView mandv=new ModelAndView();
//		mandv.addObject("itemList", itemList);
		mandv.addObject("billSummary", summary);
		mandv.setViewName("invoice");
		return mandv;
	}
}

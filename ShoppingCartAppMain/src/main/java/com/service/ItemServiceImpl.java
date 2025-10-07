package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Item;
import com.model.User;
import com.repository.ItemRepo;
import com.repository.UserRepo;

@Service
public class ItemServiceImpl implements ItemService{
	@Autowired
	private ItemRepo itemrepo;
	
	@Override
	public List<Item> getItems(List<String> itemnames) {
		List<Item> items=new ArrayList<>();
		for(String itemname: itemnames) {
			items.add(itemrepo.findByItemdesc(itemname));
		}
		
		return items;
	}
}

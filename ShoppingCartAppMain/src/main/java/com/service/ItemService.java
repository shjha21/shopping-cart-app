package com.service;

import java.util.List;

import com.model.Item;
import com.model.User;

public interface ItemService {
	public List<Item> getItems(List<String> itemnames);
}

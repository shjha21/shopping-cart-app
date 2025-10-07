package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.model.Item;

@Repository
public interface ItemRepo extends JpaRepository<Item, Integer>{
	public Item findByItemdesc(String itemdesc);
}

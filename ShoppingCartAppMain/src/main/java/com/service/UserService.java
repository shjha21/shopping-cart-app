package com.service;

import com.model.User;

public interface UserService {
	public User checkUserByNameAndPassword(String uname,String userpass);
	public boolean checkFlag(String uname);
	public void updateFlag(String uname, int flag);
	public User getUser(String name);
	public void insert(String uname, String userpass);
}

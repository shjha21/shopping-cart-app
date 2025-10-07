package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.User;
import com.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepo userrepo;
	@Override
	public User getUser(String name) {
		return Optional.ofNullable(userrepo.findByUsername(name))
				.map((n)->n)
				.orElse(null);
	}
	
	public User getUserById(int uid){
		Optional opt=userrepo.findById(uid);
		User user=(User)opt.get();
		return Optional.ofNullable(user)
				.map(n->n).orElse(null);
	}
	
	@Override
	public User checkUserByNameAndPassword(String username,String userpass) {
		return Optional.ofNullable(userrepo.findByUsernameAndUserpass(username, userpass))
				.map(n->n)
				.orElse(null);
//				.orElseThrow(()->new UserNotFoundException("Invalid Credentials..."));
	}

	@Override
	public boolean checkFlag(String uname) {
		return Optional.ofNullable(userrepo.findByUsername(uname))
		.filter(n->n.getFlag()==0)
		.map(n->true)
		.orElseGet(()->false);
	}

	@Override
	public void updateFlag(String uname, int flag) {
		Optional.ofNullable(userrepo.findByUsername(uname))
		.map(n->{n.setFlag(flag); userrepo.save(n);return n;});
		
	}

	@Override
	public void insert(String uname, String userpass) {
		User user=new User();
		user.setUsername(uname);
		user.setUserpass(userpass);
		userrepo.save(user);
	}
	}

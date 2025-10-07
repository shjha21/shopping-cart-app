package com.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.model.*;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{
	public User findByUsername(String username);
	public User findByUsernameAndUserpass(String uname, String upass);
}

package com.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.model.User;
import com.service.UserServiceImpl;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	private UserServiceImpl userservice;
	
	//Register
		@GetMapping("/register")
		public ModelAndView loadRegistrationForm() {
			ModelAndView mandv = new ModelAndView();
			mandv.addObject("userObj", new User());
			mandv.setViewName("registrationform");
			return mandv;
		}

		@PostMapping("/register")
		public ModelAndView processRegistrationForm(@Valid @ModelAttribute("userObj") User user, BindingResult result) {
			ModelAndView mandv = new ModelAndView();
			if (result.hasErrors()) {
				mandv.setViewName("registrationform");
				return mandv;
			} else {

				userservice.insert(user.getUsername(), user.getUserpass());
				System.out.println("Username" + user.getUsername() + " registered");
				mandv.setViewName("registrationform");
				return mandv;
			}
		}
	
	//Login
	@RequestMapping(method=RequestMethod.GET, value="/login")
	public ModelAndView loadLoginForm() {
		ModelAndView mandv=new ModelAndView();
		mandv.addObject("userObj", new User());
		mandv.setViewName("login");
		return mandv;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/login")
	public ModelAndView processLoginForm(@Valid @ModelAttribute("userObj")User user, BindingResult result, HttpSession session) throws Exception {
		ModelAndView mandv=new ModelAndView();
		if(result.hasErrors()) {
			mandv.setViewName("login");
			
		}
		else {
			
			String loggedIn=login(user.getUsername(), user.getUserpass());
			if(loggedIn=="login.success") {
				session.setAttribute("username", user.getUsername());
				mandv.addObject(user);
				mandv.setViewName("welcome");
				System.out.println("User "+user.getUsername()+" logged in successfully.");
				
			}
			else if(loggedIn=="login.already") {
				session.setAttribute("username", user.getUsername());
				mandv.addObject(user);
				mandv.setViewName("already");
				System.out.println("Username "+user.getUsername()+" already logged in.");
				
			}
			else if(loggedIn=="login.failure") {
				mandv.setViewName("login");
				
			}
			else {
				mandv.setViewName("login");
			}
		}
		
		return mandv;
	}
	
	public String login(String uname,String password)throws Exception {
		User user=userservice.checkUserByNameAndPassword(uname, password);
		return Optional.ofNullable(user)
				.map(n->
					Optional.ofNullable(n.getUsername())
					.filter(u->{
						try {
							return userservice.checkFlag(u);
						}catch(Exception e) {return false;}
					})
					.map(usern->{
						try {
							userservice.updateFlag(uname, 1);
						}catch(Exception e) {}
						return "login.success";
					})
					.orElse("login.already")
				)
				.orElse("login.failure");
	}
	
	//Logout
////	@RequestMapping(method=RequestMethod.POST, value="/logout")
////	public ModelAndView loadLogoutForm() {
////		ModelAndView mandv=new ModelAndView();
////		mandv.addObject("myuser", new User());
////		mandv.setViewName("login");
////		return mandv;
////	}
	
	@PostMapping("/logout")
	public ModelAndView logout(@Valid @ModelAttribute("userObj")User user, BindingResult result, HttpSession session) {
		ModelAndView mandv=new ModelAndView();
		String uname=session.getAttribute("username").toString();
		userservice.updateFlag(uname, 0);
//		mandv.addObject("myuser", new User());
		mandv.setViewName("login");
		session.invalidate();
		return mandv;
	}
//	
//	public int fetchId(String uname) {
//		User user=userservice.getUser(uname);
//		return user.getUserid();
//		
//	}
	
	
	
	
}

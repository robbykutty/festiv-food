package org.hov.controller;

import org.hov.enumerators.Authority;
import org.hov.enumerators.EmailType;
import org.hov.generators.CodeGenerator;
import org.hov.generators.EmailGenerator;
import org.hov.model.User;
import org.hov.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController 
{
	@Autowired
	UserService userService;

	CodeGenerator codeGenerator;
	EmailGenerator emailGenerator;
	
	@GetMapping("/login")
	public String login()
	{
		return "login";
	}
	
	@GetMapping("/signup")
	public String signup(ModelMap map)
	{
		map.addAttribute("user", new User());
		return "signup";
	}
	
	@PostMapping("/adduser")
	public String addUser(@ModelAttribute("user") User user)
	{
		String vCode = codeGenerator.generate(6);	//Generate Verification Code
		user.setVerificationCode(vCode);			//Set Verification Code
		user.setAuthority(Authority.BUYER); // REMOVE AFTER SELLER FN IS ADDED*******
		user.setVerified(true); 	//REMOVE AFTER LINKS-MODEL IS ADDED***************
		
		if (userService.addUser(user))
		{
			if(emailGenerator.send(EmailType.VERIFICATION, 
								   user.getFirstName(), 
								   user.getUserEmail(), 
								   0.0, 
								   "", 
								   "", 
								   vCode))
			{
				//something
			}
			return "redirect:/user/login";
		}
		else
		{
			return "redirect:/error/verification";
		}
	}
	
	@GetMapping("/verify")
	public String verify()
	{
		return "verify";
	}
}

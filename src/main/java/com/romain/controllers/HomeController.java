package com.romain.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@GetMapping("/")
	public ModelAndView home() {

		// To render a view with home.jsp
		ModelAndView mav = new ModelAndView("home");

		// Retrieving data from Security context
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = "empty";
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else {
			username = principal.toString();
		}
		// Forward data to view
		mav.addObject("principal",username);

		return mav;
	}

}

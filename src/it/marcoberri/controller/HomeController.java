package it.marcoberri.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.marcoberri.repositories.RawRepository;

@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	private RawRepository repository;

	@RequestMapping(method = RequestMethod.GET)
	public String home(ModelMap model) {
		model.addAttribute("greeting", "Hello World from Spring 4 MVC");
		return "index";
	}

}
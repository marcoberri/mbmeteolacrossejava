package it.marcoberri.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.marcoberri.model.Raw;
import it.marcoberri.repositories.RawRepository;

@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	private RawRepository rawRepository;

	@RequestMapping(method = RequestMethod.GET)
	public String home(ModelMap model) {
		List<Raw> rawList = rawRepository.findAll();
		//Raw rawLast = rawRepository.findOneLastRecord(new Sort(Sort.Direction.DESC, "$natural"));
		model.addAttribute("greeting", "Hello World from Spring 4 MVC");
		
		//model.addAttribute("last", rawLast);
		

		return "index";
	}

}
package it.marcoberri.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
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
		final Page<Raw> raw = rawRepository.findAll(new PageRequest(0, 1, new Sort(Direction.DESC,"ts")));

		//model.addAttribute("greeting", "Hello World from Spring 4 MVC");
		model.addAttribute("last", raw.getContent().get(0));

		return "index";
	}

}
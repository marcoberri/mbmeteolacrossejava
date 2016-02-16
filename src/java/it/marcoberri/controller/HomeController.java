package it.marcoberri.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.marcoberri.model.Raw;
import it.marcoberri.model.SystemData;
import it.marcoberri.repositories.RawRepository;
import it.marcoberri.repositories.SystemDataRepository;

@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	private RawRepository rawRepository;

	@Autowired
	private SystemDataRepository sysRepository;

	@RequestMapping(method = RequestMethod.GET)
	public String home(ModelMap model) {
		final Raw rawLast = rawRepository.findFirstByOrderByTsDesc();
		final SystemData sysLast = sysRepository.findFirstByOrderByTsDesc();
		System.out.println(sysLast);
		model.addAttribute("last", rawLast);
		model.addAttribute("lastsys", sysLast);
		return "index";
	}

}
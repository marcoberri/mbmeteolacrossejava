package it.marcoberri.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/rest")
public class RestController {

	@RequestMapping(method = RequestMethod.GET)
	public String home(ModelMap model) {
		// rawRepository.findOne();
		// Raw rawLast = rawRepository.findOneLastRecord(new
		// Sort(Sort.Direction.DESC, "$natural"));
		model.addAttribute("greeting", "Hello World from Spring 4 MVC");

		// model.addAttribute("last", rawLast);

		return "index";
	}

}
package it.marcoberri.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import it.marcoberri.repositories.RawRepository;

@Controller
@RequestMapping("/rest")
public class RestController {

	@Autowired
	private RawRepository rawRepository;

}
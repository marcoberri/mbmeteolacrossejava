package it.marcoberri.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import it.marcoberri.model.Raw;
import it.marcoberri.repositories.RawRepository;
import it.marcpberri.helper.PathConstants;

@Controller
@RequestMapping("/rest")
public class RestController {

	@Autowired
	private RawRepository rawRepository;


}
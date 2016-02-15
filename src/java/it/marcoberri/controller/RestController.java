package it.marcoberri.controller;

import java.util.Date;
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

	@RequestMapping(value = "/T/{" + PathConstants.PARAM_FILTER_FROM_DAY
			+ "}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Raw> getValues(@PathVariable(value = PathConstants.PARAM_FILTER_FROM_DAY) int dayFirst) {

		final Page<Raw> rawLastList = rawRepository.findAll(new PageRequest(0, 1, new Sort(Direction.DESC, "ts")));
		final Raw rawLast = rawLastList.getContent().get(0);

		long fromDateMillis = rawLast.getTs().getTime() - (86400000 * dayFirst);

		return rawRepository.findByTsGreaterThan(new Date(fromDateMillis), new Sort(Direction.ASC, "ts"));

	}

}
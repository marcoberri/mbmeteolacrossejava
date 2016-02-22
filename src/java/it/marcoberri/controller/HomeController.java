package it.marcoberri.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
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
		final Sort sort = new Sort(Direction.DESC, "ts");
		final Raw rawLast = rawRepository.findFirstBy(sort);
		final SystemData sysLast = sysRepository.findFirstByOrderByTsDesc();
		model.addAttribute("last", rawLast);
		model.addAttribute("lastsys", sysLast);
		return "index";
	}

	@RequestMapping(method = RequestMethod.GET, path = "/archive")
	public String archive(ModelMap model) {

		final List<Raw> rawDistTs = rawRepository.findAll();

		Set<String> dates = new LinkedHashSet<String>();

		Calendar cal = Calendar.getInstance();
		Calendar calCurrent = Calendar.getInstance();
		calCurrent.setTime(new Date());
		
		for (Raw r : rawDistTs) {
			if (r.getTs() == null)
				continue;
			
			cal.setTime(r.getTs());
			
			if(calCurrent.get(Calendar.MONDAY) == cal.get(Calendar.MONTH) && calCurrent.get(Calendar.YEAR) == cal.get(Calendar.YEAR))
				continue;
					
			
			final String key = ((cal.get(Calendar.MONTH) + 1)  < 10 ? "0" + (cal.get(Calendar.MONTH) + 1) : (cal.get(Calendar.MONTH) + 1)) + "/" + cal.get(Calendar.YEAR);
			
			if (dates.contains(key))
				continue;
			
			
			dates.add(key);
		}

		List<String> listParagraph = new ArrayList<String>(dates);
		Collections.sort(listParagraph);

		

		model.addAttribute("dates", listParagraph);

		return "archive";
	}

}
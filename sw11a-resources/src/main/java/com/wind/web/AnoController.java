package com.wind.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AnoController {
	
	@RequestMapping("/content/contentview")
	public String contentView(Model model) {
		model.addAttribute("id", "GANA");
		
		return "/content/contentview";
		
	}

}

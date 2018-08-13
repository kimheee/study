package com.wind.web.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wind.web.dao.BDao;
import com.wind.web.dto.BDto;

@Controller
public class BController {
	
	//BService service = null;
	//private JdbcTemplate template;
	
	//@Autowired
	//public void setTemplate(JdbcTemplate template) {
		//this.template = template;
		//Constant.template = this.template;
	//}
	
	BDao dao;
	
	@Autowired
	public void setDao(BDao dao) {
		this.dao = dao;
	}
	
	
	@RequestMapping("/list")
	public String list(Model model) { 
		//service = new BListService();
		//service.execute(model);
		ArrayList<BDto> dtos = dao.list();
		model.addAttribute("list", dtos);
		return "list";
	}
	
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request,Model model) {	
		model.addAttribute("request", request);
		//service = new BContentService();
		//service.execute(model);
		BDto dto = dao.contentView(request.getParameter("bId"));
		model.addAttribute("content_view", dto);
		return "content_view";
	}	
	
	@RequestMapping("/write_view")
	public String write_view() {
		return "write_view";	
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request,Model model) {
		//model.addAttribute("request", request);
		//service = new BWriteService();
		//service.execute(model);
		dao.write(request.getParameter("bName"), request.getParameter("bContent"));
		return "redirect:list";	
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request,Model model) {
		//model.addAttribute("request", request);
		//service = new BDeleteService();
		//service.execute(model);
		System.out.println(request.getParameter("bId"));
		dao.delete(request.getParameter("bId"));
		return "redirect:list";	
	}

}

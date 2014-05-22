package com.easyweb.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.easyweb.service.EntryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/entry")
public class EntryController {
	@Resource
	private EntryService entryService;

	@RequestMapping("/createDB")
	public String createDB(HttpServletRequest request){

		
		return "/index";
	}
}
package com.budgethelper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public final class MainController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String main() {
		return "/angular/index.html";
	}
}

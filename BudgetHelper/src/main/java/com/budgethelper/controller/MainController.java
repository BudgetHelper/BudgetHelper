package com.budgethelper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by vyach on 06.08.2017.
 */
@Controller
public class MainController {

	@RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
	public String login() {
		return "login.jsp";
	}
}

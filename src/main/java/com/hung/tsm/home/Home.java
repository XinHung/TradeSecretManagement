package com.hung.tsm.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/tsm")
@Controller
public class Home {
	@GetMapping({"/home", "/", ""})
	public String home() {
		return "home";
	}
}

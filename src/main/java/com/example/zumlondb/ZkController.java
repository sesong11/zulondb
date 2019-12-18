package com.example.zumlondb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ZkController {
	@GetMapping("/home")
	public String homePage() {
		return "home";
	}
}

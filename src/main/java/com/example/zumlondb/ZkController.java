package com.example.zumlondb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ZkController {
		
	@GetMapping("/{page}")
    public String viewPage(@PathVariable("page") String page) {
        return "home";
    }
}

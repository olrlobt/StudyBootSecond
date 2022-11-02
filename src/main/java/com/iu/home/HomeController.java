package com.iu.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

	@GetMapping("/admin")
	@ResponseBody
	public String admin() throws Exception {
		
		return "Admin Role";
	}
	@GetMapping("/manager")
	@ResponseBody
	public String manager() throws Exception {
		
		return "Manager Role";
	}
	@GetMapping("/user")
	@ResponseBody
	public String member() throws Exception {
	
		return "Member Role";
	}
	
	
	
	@GetMapping("/")
	public String home() throws Exception {
		

		return "index";
	}
}

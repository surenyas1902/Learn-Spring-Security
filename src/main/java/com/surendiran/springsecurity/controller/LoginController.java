package com.surendiran.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/formlogin")
	public String formLoginPage() {
		return "form-login";
	}
	
	// add request mapping for access denied
	@GetMapping("/404")
	public String AccessDeniedPage() {
		return "404";
	}
}

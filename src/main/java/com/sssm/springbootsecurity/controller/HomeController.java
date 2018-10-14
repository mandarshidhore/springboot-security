package com.sssm.springbootsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello";
	}

	@GetMapping("/getsavingsaccountbalance/{acctNumber}")
	public int getsavingsaccountbalance(@PathVariable("acctNumber") final String acctNumb) {
		return 100;
	}

	@GetMapping("/getcheckingaccountbalance/{acctNumber}")
	public int getcheckingaccountbalance(@PathVariable("acctNumber") final String acctNumb) {
		return 100;
	}
	
	@GetMapping("/getuserdetails/admin/{acctNumber}")
	public int getUserDetails(@PathVariable("acctNumber") final String acctNumb) {
		return 200;
	}

}

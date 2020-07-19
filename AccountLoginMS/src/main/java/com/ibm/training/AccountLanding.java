package com.ibm.training;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountLanding {
	
	@GetMapping("/accountDetails")
	public String accountDetails() {
		return "Inside Account Landing page";
	}

}

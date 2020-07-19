package com.ibm.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.training.model.JwtRequest;
import com.ibm.training.util.JwtUtil;

@RestController
public class AuthanticateController  {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@PostMapping("/createAuthenticationToken")
	ResponseEntity<String> createAuthenticationToken(@RequestBody JwtRequest jwtRequest) {
		authenticationManager.authenticate( new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(),jwtRequest.getPassword()) );
		
		UserDetails userDetails=userDetailsService.loadUserByUsername(jwtRequest.getUsername());
		String jwt = jwtUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(jwt);
	}
	
	@PostMapping("/ping")
	public String ping() {
		return "Inside ping";
	}

}

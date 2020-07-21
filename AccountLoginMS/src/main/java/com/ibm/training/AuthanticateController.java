package com.ibm.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.training.model.JwtRequest;
import com.ibm.training.util.JwtUtil;

@RestController
@RequestMapping("/AuthanticateController")
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
	
	@PostMapping("/validateAuthenticationToken")
	ResponseEntity<String> validateAuthenticationToken(@RequestBody String token){
		String userName = "bootcamp";
		Boolean isvalidToken = false;
		String msg = "";
		try {
			isvalidToken = jwtUtil.validateToken(token, userName);
		}catch (Exception e) {
			e.printStackTrace();
			msg = e.getMessage();
		}
		return ResponseEntity.ok(isvalidToken+" "+msg);
	}
	
	@GetMapping("/ping")
	public String ping() {
		return "Inside ping";
	}

}

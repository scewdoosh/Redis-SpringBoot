package com.cosa.rest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cosa.model.JwhatModel;
import com.cosa.service.ServiceClass;

@RestController
public class ControlRoom {
	@Autowired
	private ServiceClass service;
	
	@PostMapping("/post-token")
	public String postToken(@RequestBody JwhatModel model) {
		return service.saveToken(model);
	}
	@GetMapping("/get-all-token")
	public Collection<Object> getAllTokens() {
		return service.getAlluserAndToken();
	}
}

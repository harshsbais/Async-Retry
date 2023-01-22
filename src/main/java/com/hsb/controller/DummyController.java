package com.hsb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hsb.service.DummyService;

@RestController
public class DummyController {
	
	@Autowired
	public DummyService service;

	@GetMapping("/hello")
	public String getMessage() {
		try {
			return service.getMessage();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

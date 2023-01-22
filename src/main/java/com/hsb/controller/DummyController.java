package com.hsb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hsb.service.DummyService;

import reactor.core.publisher.Mono;

@RestController
public class DummyController {
	
	@Autowired
	public DummyService service;

	@GetMapping("/retry-scenario")
	public String getMessage() {
		try {
			return service.getMessage();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/async-scenario")
	public Mono getAsyncResponse() {
		return service.mergeData();
	}
	
	@GetMapping("/sync-scenario")
	public String getSyncResponse() {
		return service.getSyncData();
	}
}

package com.hsb.util;

import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

public class DummyUtil {

	static WebClient webClient = WebClient.create("https://dummyjson.com");
	
	public static Mono<String> getMonoResponse(int id){
		return webClient.get()
		        .uri("/products/{id}", id)
		        .retrieve()
		        .bodyToMono(String.class);
	}
	
	public static String getStringResponse(int id){
		return webClient.get()
    	        .uri("/products/{id}", id)
    	        .retrieve()
    	        .toEntity(String.class)
    	        .block().getBody();
	}
	
}

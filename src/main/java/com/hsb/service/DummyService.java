package com.hsb.service;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.hsb.exception.DummyException;
import com.hsb.util.DummyUtil;

import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuple8;

@Service
public class DummyService {

    @Retryable(value = DummyException.class, maxAttempts = 2, backoff = @Backoff(delay = 100))
	public String getMessage() throws Exception {
    	throw new DummyException();
	}
    
    @Recover
    public String getRecoveryMessage() {
    	return "Recovery Message";
    }
    
    public Mono<String> mergeData() {
        Mono<String> mono1 = DummyUtil.getMonoResponse(1);
        Mono<String> mono2 = DummyUtil.getMonoResponse(2);
        Mono<Tuple2<String, String>> zipped=Mono.zip(mono1,mono2);
        
        return zipped.map(tuple -> {
        	return tuple.getT1() + tuple.getT2();
        });

    }
    
    public String getSyncData() {
    	String a = DummyUtil.getStringResponse(3);
    	String b = DummyUtil.getStringResponse(4);
    	
    	return a+b;
    }
}

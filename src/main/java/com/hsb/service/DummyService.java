package com.hsb.service;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import com.hsb.exception.DummyException;

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
}

package com.hsb.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DummyException extends Exception {
	
    private static Logger logger = LoggerFactory.getLogger(DummyException.class);


	public DummyException() {
		logger.error("Exception Thrown");
	}
}

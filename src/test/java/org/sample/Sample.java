package org.sample;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Sample {
	
	static Logger logger = LogManager.getLogger(Sample.class);
	
	public static void main(String[] args) {
		
		System.out.println("Hello world");
		logger.info("This is an Information");
		logger.error("Error Message");
		logger.fatal("Fatal message");
		logger.warn("Warning Message");
		
		System.out.println("Completed");
		
		
	}

}

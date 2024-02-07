package com.test.qa;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4J_Logging {

	// Log4j is a popular logging framework in Java that can be used to log messages
	// at different levels (info, debug, error, etc.) during the execution of your
	// Selenium scripts.
	// Step 1: Add Log4j Dependency
	// Step 2: Create a Log4j Configuration File

	// Define the logger
	private static final Logger logger = LogManager.getLogger(Log4J_Logging.class);

	// Example method to log a step
	public void logStep(String stepDescription) {
		logger.info("Step: " + stepDescription);
	}

	// Add more methods for different log levels (e.g., debug, error, warn) as
	// needed

	public static void main(String[] args) {
		// Initialize Log4jExample
		Log4J_Logging log4jExample = new Log4J_Logging();

		// Log steps
		log4jExample.logStep("Starting the application");
		// Perform some actions
		log4jExample.logStep("Performing an action");
		// More steps...

		// Close the application
		log4jExample.logStep("Closing the application");
	}
}

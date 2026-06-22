package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {
	private static final Logger Logger = LogManager.getLogger();
	
	public static void info(String message) {
		Logger.info(message);
	}
	
	public static void warn(String message) {
		Logger.warn(message);
	}
	
	public static void error(String message) {
		Logger.error(message);
	}
	
	public static void debug(String message) {
		Logger.debug(message);
	}
	
}
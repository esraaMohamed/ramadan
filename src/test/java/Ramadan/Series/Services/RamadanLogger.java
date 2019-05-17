package Ramadan.Series.Services;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


/**
 * @author ahmedyoussef 
 * 
 * Initial step to send the app's logs to the syslog and newbase log center
 *
 */
public class RamadanLogger {

	private static final Logger logger = LogManager.getLogger(RamadanLogger.class);
	
	public static void info(String text) {
		logger.info(text);
	}
	
	public static void error(String text, Exception e) {
		logger.error(text, e);
	}
}

package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LogTest {

	public static void main(String[] args) {
		Log log = LogFactory.getLog(LogTest.class);
		log.info("log info...");
		
		log.debug(1/0);
		

	}

}

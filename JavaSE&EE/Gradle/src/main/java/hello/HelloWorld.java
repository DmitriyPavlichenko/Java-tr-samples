package hello;

import java.util.logging.Logger;

public class HelloWorld {
	static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	public static void main(String[] args) {
		logger.info("Hello World");
	}

}

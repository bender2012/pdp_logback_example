package pdp_example.logback_example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

	private static final Logger logger = LoggerFactory.getLogger(App.class);
	private static final String SAMPLE_STRING_TO_LOG = "Hello World!!!";

	public static void main(String[] args) {
		logger.info(SAMPLE_STRING_TO_LOG);
	}
}

package utilities;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public final class Log {

	private final static Logger log = Logger.getLogger(Log.class);

	private static Log instance = new Log();

	public static Log getInstance() {
		return instance;
	}

	private Log() {
		log.setLevel(Level.ALL);
		PropertyConfigurator.configure("resource/log4j.properties");
	}

	public void info(String m) {
		log.info(m);
	}

	public void error(String m) {
		log.error(m);
	}
}

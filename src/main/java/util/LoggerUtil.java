package util;

import lombok.experimental.UtilityClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@UtilityClass
public class LoggerUtil {
    private static final Logger logger = LogManager.getLogger(LoggerUtil.class);

    public void info(String message) {
        logger.info(message);
    }

    public void error(String message, Throwable t) {
        logger.error(message, t);
    }
}

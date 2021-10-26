package Fullstack.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//Global Logger-class
public class AppLogger {
    static Logger logger = LoggerFactory.getLogger(AppLogger.class);

    public static Logger getLogger() {
        return logger;
    }
}

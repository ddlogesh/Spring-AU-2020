package logging;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class LogDemo {
    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args){
        log.trace("trace");
        log.debug("debug");
        log.info("info");
        log.warn("warn");
        log.error("error");
        log.fatal("fatal");
    }
}
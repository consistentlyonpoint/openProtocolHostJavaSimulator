import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.Logger.*;
//import org.apache.log4j.Level;

import java.io.*;
//import java.nio.file.*;
//import java.util.*;

//import java.text.SimpleDateFormat;
//import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class hostLogger {
    // protected static final Logger logger = LogManager.getLogger();
    protected static final Logger logger = LogManager.getLogger(hostLogger.class);
    // protected static final Logger logger2 = Logger.getLogger(JavaClass.class.getName());
    // protected static final Logger logger2 = Logger.class.getName();
    // protected static final Logger logger3 = LogManager.getLogger().set

    static void hostLog(String inFile, String inLog, String logType) {
        System.out.println("the inputs were: \n" + inFile + "\n" + inLog);
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
//        String logTimeStamp = zonedDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSSSxxx").withZone(ZoneId.of("GMT")));
        String logTimeStamp = zonedDateTime.format(DateTimeFormatter.ofPattern("yyyyMMddHH"));
//        System.out.println("the log file time: \n" + logTimeStamp);

        String logFileName = inFile + "_" + logTimeStamp + ".log";
//        System.out.println("the logFileName: \n" + logFileName);

        File logFolder = new File(System.getProperty("user.dir") + "/hostLogs" + "/"+inFile);
        // File logFolder = new File("../hostLogs");
        if (!logFolder.exists()) {
            logFolder.mkdir();
        }

        String joinFolder = "\\";
        // Path absLogFilePath = Paths.get(logFolder + joinFolder + logFileName);
        String absLogFilePath = logFolder + joinFolder + logFileName;
        System.setProperty("logFilePath", absLogFilePath);
        //
        try {
//            if ("info".equals(logType)) {
//                logger.info(inLog);
//            } else if ("debug".equals(logType)) {
//                logger.debug(inLog);
//            } else if ("error".equals(logType)) {
//                logger.error(inLog);
//            } else if ("trace".equals(logType)) {
//                logger.trace(inLog);
//            } else if("warn".equals(logType)) {
//                logger.warn(inLog);
//            } else if("fatal".equals(logType)) {
//                logger.fatal(inLog);
//            } else {
//                logger.log(Level.getLevel(logType), inLog);
//            }
//            logger.isEnabled(Level.ALL);
            logger.log(Level.getLevel(logType), inLog);

//            LogManager.shutdown();
        } catch (Throwable r) {
            System.out.println("Exception in logging?\n: " + r.getMessage());
        }
    }
}
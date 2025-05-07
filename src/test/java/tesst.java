import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class tesst {
    private static final Logger logger = LogManager.getLogger(tesst.class);

    public static void main(String[] args) {
        logger.trace("TRACE test");
        logger.debug("DEBUG test");
        logger.info("INFO test");
        logger.warn("WARN test");
        logger.error("ERROR test");
    }
}

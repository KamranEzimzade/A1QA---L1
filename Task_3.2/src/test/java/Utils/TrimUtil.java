package Utils;

import org.apache.log4j.Logger;

public class TrimUtil {
    private static Logger log = Logger.getLogger(TrimUtil.class);


    public static String trimTheResult(String result) {
        log.info("Triming the given string to leave only the generated random text");
        return result.substring(result.indexOf(" ") + 8).trim();
    }
}

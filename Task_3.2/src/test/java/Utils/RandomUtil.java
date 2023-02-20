package Utils;

import java.util.Random;

import org.apache.log4j.Logger;

public class RandomUtil {

    private static final int lenghtOfRandomText = 8;
    private static Logger log = Logger.getLogger(RandomUtil.class);


    public static String generateRandomText() {
        log.info("Generating random string with a given length");

        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        StringBuilder sb = new StringBuilder();

        Random random = new Random();

        int length = lenghtOfRandomText;

        for (int i = 0; i < length; i++) {

            int index = random.nextInt(alphabet.length());

            char randomChar = alphabet.charAt(index);

            sb.append(randomChar);
        }

        String randomString = sb.toString();
        return randomString;

    }
}

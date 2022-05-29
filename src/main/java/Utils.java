import org.apache.commons.lang3.RandomStringUtils;

public class Utils {
    private Utils() {
    }

    public static String randomString(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }
}

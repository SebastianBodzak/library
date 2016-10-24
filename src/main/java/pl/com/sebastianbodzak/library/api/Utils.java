package pl.com.sebastianbodzak.library.api;

/**
 * Created by Dell on 2016-10-24.
 */
public class Utils {

    public static boolean validateString(String string) {
        return string == null || string.trim().isEmpty();
    }
}

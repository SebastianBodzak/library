package pl.com.sebastianbodzak.library.api;

import java.util.regex.Pattern;

/**
 * Created by Dell on 2016-10-12.
 */
public class PhoneValidator {

    private static final String PHONE_PATTERN_1 = "\\d{3}-\\d{3}-\\d{3}";
    private static final String PHONE_PATTERN_2 = "\\d{3}\\d{3}\\d{3}";

    private Pattern pattern;
    private Pattern pattern2;

    public PhoneValidator() {
        pattern = Pattern.compile(PHONE_PATTERN_1);
        pattern2 = Pattern.compile(PHONE_PATTERN_2);
    }

    public boolean validate(final String hex) {
        return pattern.matcher(hex).matches() || pattern2.matcher(hex).matches();

    }
}

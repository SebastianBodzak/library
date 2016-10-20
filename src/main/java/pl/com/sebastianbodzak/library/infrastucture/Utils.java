package pl.com.sebastianbodzak.library.infrastucture;

import java.util.List;

/**
 * Created by Dell on 2016-10-20.
 */
public class Utils {

    public static <T> T returnSingleResult(List<T> result) {
        return result.isEmpty() ? null : result.get(0);
    }
}

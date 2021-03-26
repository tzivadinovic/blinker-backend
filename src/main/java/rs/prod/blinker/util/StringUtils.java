package rs.prod.blinker.util;

import java.text.Normalizer;

public class StringUtils extends org.springframework.util.StringUtils{
    public static String normalize(String toBeNormalized) {
        return Normalizer
                .normalize(toBeNormalized, Normalizer.Form.NFKD)
                .replaceAll("[^\\p{ASCII}]", "");
    }

    public static String throwIfEmpty(String str) {
        if (str == null || str.isEmpty())
            throw new IllegalArgumentException();
        return str;

    }

}

package util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by adri on 12/9/16.
 */
public class EncodeURIComponent {
    public static String encodeURIComponent(String s) {
        String result;

        try {
            result = URLEncoder.encode(s, "UTF-8")
                    .replaceAll("\\+", "%20")
                    .replaceAll("\\%21", "!")
                    .replaceAll("\\%27", "'")
                    .replaceAll("\\%28", "(")
                    .replaceAll("\\%29", ")")
                    .replaceAll("\\%7E", "~");

        } catch (UnsupportedEncodingException e) {
            result = s;
        }

        return result;
    }
}

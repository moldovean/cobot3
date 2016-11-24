package playground;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cobot on 11/24/16.
 */
public class ServicePlay {
    public static String getMessage(){
        return "This is a generated msg from Service";
    }
    public static List<String> provideList(){
        List<String> res = new ArrayList<>();
        res.add("Adrian");
        res.add("Cornel");
        res.add("Victor");
        res.add("Iulia");
        return res;
    }
}

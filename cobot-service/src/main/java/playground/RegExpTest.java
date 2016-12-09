package playground;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by adri on 12/9/16.
 */
public class RegExpTest {
    public static void main(String[] args) {
        String utterance = "`DexOnline getDexDefinition cartier`";
        Pattern rexExp = Pattern.compile("`(.+?)`");
        Matcher m = rexExp.matcher(utterance);
        if(m.find()){
            System.out.println(m.group(1));
        }
    }
}

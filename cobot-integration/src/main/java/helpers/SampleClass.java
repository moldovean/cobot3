package helpers;

import java.util.List;

/**
 * Created by adri on 12/8/16.
 */

// You use SampleClass and SampleClass2 -> can remove ?
public class SampleClass {
    public static String sampleRun(String string) {
        return "This is the output from the class";
    }
    public static String sampleRun2(String string) {
        return string+"This is the second run from the class";
    }

    public static String sampleRun3(List<String> list){
        for (String arg : list) {
            System.out.println("iaka: "+arg);
        }
        return "iaka returnul";
    }
}
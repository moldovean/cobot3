package nlp;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by adri on 12/10/16.
 */
public class RomanianLetters {
    private static HashMap<String, String> roToAnsi = new HashMap<>();
    private static HashMap<String, String> roCorrection = new HashMap<>();

    static {
        roCorrection.put("ţ","ț");
        roCorrection.put("ş","ș");
        roToAnsi.put("ţ","t");
        roToAnsi.put("ş","s");
        roToAnsi.put("ț","t");
        roToAnsi.put("ș","s");

    }

    private RomanianLetters() {
    }

    public static String removeDiacritics(String sentence){
        return sentence
                .replaceAll("ţ","t")
                .replaceAll("ț","t")
                .replaceAll("ş","s")
                .replaceAll("ș","s")
                .replaceAll("ă","a")
                .replaceAll("â","a")
                .replaceAll("î","i");
    }
    public static void correctRoLetters(){

    }

    public static void main(String[] args) {
        String prop = "Floricică şi-o surcea, ţap ispășitor";
        System.out.println(removeDiacritics(prop));
    }

}

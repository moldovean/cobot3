package nlp;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by adri on 12/5/16.
 */
public class LemmaRo {
    // this class is basically mocking a lemmitization mapping in Romanian with the use of a dictionary.
    // It works more like stemming rather than proper lemmitization, which uses POS taggs.
    // But it's the best one can have at the moment.
    private static final Map<String, String> lemmaRo;
    private static String pathToDic = "cobot-integration/src/main/resources/lemmatization/lemmatization-ro.txt";
    // http://www.lexiconista.com/datasets/lemmatization/  <-- a contribution from Martin Verel, Civita.

    static {
        lemmaRo = new HashMap<>();
        File file = new File(pathToDic);
        String words[];
        String line;
        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(file), "UTF-8"))) {
            while ((line=br.readLine())!=null){
                words = line.split("\\s");
                lemmaRo.put(words[1], words[0]);
            }

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private LemmaRo(){

    }

    public static HashMap<String, String> getLemmaRo() {
        return (HashMap<String, String>) lemmaRo;
    }

    public static String getLemma(String word){
        if (lemmaRo.containsKey(word))
            return lemmaRo.get(word);
        return word;
    }
}



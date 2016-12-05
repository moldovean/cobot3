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
    private static Map<String, String> lemmaRo;
    private static String pathToResources = "/home/adri/Documents/code/java/hack/cobot3/cobot-integration/src/main/resources/";
    // http://www.lexiconista.com/datasets/lemmatization/  <-- a contribution from Martin Verel, Civita.


    private LemmaRo(){

    }

    public static synchronized HashMap<String, String> getLemmaRo() {
        if (lemmaRo==null){
            lemmaRo = new HashMap<>();
            File file = new File(pathToResources+"lemmatization/lemmatization-ro.txt");
            String words[];
            String line;

            // la FileInputStream charsetName "UTF-8" mod
            try(BufferedReader br = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(file)))) {
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
        return (HashMap<String, String>) lemmaRo;
    }

    public static String getLemma(String word){
        if (getLemmaRo().containsKey(word))
            return getLemmaRo().get(word);
        return word;
    }
    public static void setPathToResources(String path){
        pathToResources = path;
    }
}



package nlp;

import util.ResourcesPath;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
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

    // for linux
    //private static String pathToResources = "/home/adri/Documents/code/java/hack/cobot3/cobot-integration/src/main/resources/";
    // for windows only: D:\Work\GitProjects\cobot3\cobot-integration\src\main\resources
    private static String pathToResources;

    // http://www.lexiconista.com/datasets/lemmatization/  <-- a contribution from Martin Verel, Civita.

    static {
        if(System.getProperty("os.name").contains("Windows")){
            pathToResources = ResourcesPath.getResourcePath()+"\\lemmatization\\lemmatization-ro.txt";
        }
        else {
            pathToResources = ResourcesPath.getResourcePath()+"/lemmatization/lemmatization-ro.txt";
        }
        removeRecursionLvl1();
        removeRecursionLvl2();
        removeRecursionLvl3();
    }

    private LemmaRo() {

    }


    public static synchronized HashMap<String, String> getLemmaRo() {
        if (lemmaRo == null) {
            lemmaRo = new HashMap<>();
            //File file = new File(pathToResources + "lemmatization/lemmatization-ro.txt");
            File file = new File(pathToResources);
            String words[];
            String line;

            // la FileInputStream charsetName "UTF-8" mod
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(file)))) {
                while ((line = br.readLine()) != null) {
                    words = line.split("\\s+");
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
        //removeRecursionLvl1();
        //emoveRecursionLvl2();
        //three lvl recursion removal is enough for practical purposes
        return (HashMap<String, String>) lemmaRo;
    }

    public static String getLemma(String word) {
        if (getLemmaRo().containsKey(word))
            return getLemmaRo().get(word);
        return word;
    }

    public static void setPathToResources(String path) {
        pathToResources = path;
    }

    public static void removeRecursionLvl1() {
        Map<String, String> dic = getLemmaRo();
        ArrayList<String> vals = new ArrayList<>(dic.values());

        for (String val : vals) {
            if (val.equals(dic.get(dic.get(val)))) {
                dic.remove(val);
            }
        }
    }

    public static void removeRecursionLvl2() {
        Map<String, String> dic = getLemmaRo();
        ArrayList<String> vals = new ArrayList<>(dic.values());
        for (String val : vals) {
            if (val.equals(dic.get(dic.get(dic.get(val))))) {
                dic.remove(val);
            }
        }
    }

    public static void removeRecursionLvl3() {
        Map<String, String> dic = getLemmaRo();
        ArrayList<String> vals = new ArrayList<>(dic.values());
        for (String val : vals) {
            if (val.equals(dic.get(dic.get(dic.get(dic.get(val)))))) {
                dic.remove(val);
            }
        }
    }
}



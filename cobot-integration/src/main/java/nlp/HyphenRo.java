package nlp;

import util.ResourcesPath;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by adri on 12/18/16.
 */
public class HyphenRo {
    private static Map<String, String> cratimaRo;
    private static String pathToResources;
    private static Path pathResources;
    static {
        cratimaRo = new HashMap<>();
        if(System.getProperty("os.name").contains("Windows")){
            pathToResources = ResourcesPath.getResourcePath()+"\\lemmatization\\cratima.txt";
        }
        else {
            pathToResources = ResourcesPath.getResourcePath()+"/lemmatization/cratima.txt";
        }
        pathResources = Paths.get(pathToResources);

    }
    private HyphenRo() {

    }

    public static String dehyphenise(String word){
        if(getCratimaRo().containsKey(word)) return getCratimaRo().get(word);
        for (String hyphenSuffix : getCratimaRo().keySet()){
            if(word.endsWith(hyphenSuffix)){
                int index = word.lastIndexOf(hyphenSuffix);
                word = word.substring(0,index)+" "+getCratimaRo().get(hyphenSuffix);
                return word;
            }
        }
        return word;
    }

    public static Map<String, String> getCratimaRo() {
        if(cratimaRo.isEmpty()){
            List<String> lines = new ArrayList<>();
            try {
                lines = Files.readAllLines(pathResources);
                String words[];
                lines.stream().forEach(x->{String[] temp = x.split("\\s\\s\\s\\s");
                                            cratimaRo.put(temp[0],temp[1]);});

                /*for (String line : lines) {
                    words = line.split("\\s\\s\\s\\s");
                    cratimaRo.put(words[0], words[1]);
                }*/
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return cratimaRo;
    }

    public static List<String> test() throws IOException {
        List<String> res = new ArrayList<>();
        res = Files.readAllLines(pathResources);
        return res;
    }

}

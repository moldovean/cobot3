package nlp;

import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.ling.Sentence;
import edu.stanford.nlp.process.DocumentPreprocessor;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by adri on 12/5/16.
 */
public class Tokenizer {
    public static ArrayList<String> tokenizeSentences(String paragraph){
        //Reader reader = new StringReader(paragraph);
        DocumentPreprocessor dp = new DocumentPreprocessor(
                                        new StringReader(paragraph));
        ArrayList<String> sentenceList = new ArrayList<>();

        dp.forEach(x->sentenceList.add(Sentence.listToString(x)));
        return  sentenceList;
    }

    public static String lemmatizeSentence(String sentence){
        String[] words;
        words = sentence.split("\\s");

        ArrayList<String> wordsArray = Arrays.asList(words).stream().map(LemmaRo::getLemma).collect(ArrayList::new,(x,y)->x.add(y),ArrayList::addAll);
        String result = String.join(" ", wordsArray);
        return result;
    }
}

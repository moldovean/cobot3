package nlp;

import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.ling.Sentence;
import edu.stanford.nlp.process.DocumentPreprocessor;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        // at the moment it is lemmatizing based on a large Romanian Dictionary
        // it would be better to lemmatize it based on POS tagging.
        String[] words;
        words = sentence.split("\\s+");

        ArrayList<String> wordsArray = Arrays.asList(words).stream()
                .parallel()
                .map(HyphenRo::dehyphenise)
                .map(HyphenRo::dehypheniseSuffix)
                .map(LemmaRo::getLemma)
                .collect(ArrayList::new,(x,y)->x.add(y),ArrayList::addAll);
        String result = String.join(" ", wordsArray);
        return result;
    }

    public static String lemmatizeParagraph(String paragraph){
        List<String> sentences = Tokenizer.tokenizeSentences(paragraph);
        List<String> tokenizedSentences = sentences.stream()
                                            .map(Tokenizer::lemmatizeSentence)
                                            .collect(ArrayList::new,ArrayList::add,ArrayList::addAll);

        return String.join(" ",tokenizedSentences);
    }
}

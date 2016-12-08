package playground.old;

import nlp.LemmaRo;
import nlp.Tokenizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by adri on 12/5/16.
 */
public class SentenceTokenizerTest {
    public static void main(String[] args) {
        String par = "The inter Mr. Turcanu is the intern at endava. He likes going shopping for sweets.";
        /*List<String> sentences = Tokenizer.tokenizeSentences(par);
        sentences.forEach(System.out::println);
        List<String> sentencesTokenized = sentences.stream()
                .map(Tokenizer::lemmatizeSentence)
                .collect(ArrayList::new,ArrayList::add,ArrayList::addAll);
        System.out.println(sentencesTokenized);*/

//        String[] words = {"El", "batjocoream", "duce", "sa", "faca", "un", "abacului"};
//        ArrayList<String> wordsArray = Arrays.asList(words).stream().map(LemmaRo::getLemma).collect(ArrayList::new,(x, y)->x.add(y),ArrayList::addAll);
//        String[] words = {"El", "batjocoream", "duce", "sa", "faca", "un", "abacului"};
//        Arrays.asList(words).stream().map(LemmaRo::getLemma).forEach(System.out::println);
        System.out.println(Tokenizer.lemmatizeParagraph(par));
    }
}

package playground;

import nlp.LemmaRo;
import nlp.Tokenizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by adri on 12/5/16.
 */
public class SentenceTokenizerTest {
    public static void main(String[] args) {
        String par = "This is a paragrath. El batjocoream duce sa faca un abacului. Eu ma duc la magazin.";
        List<String> sentences = Tokenizer.tokenizeSentences(par);
        sentences.forEach(System.out::println);
        sentences.stream().map(Tokenizer::lemmatizeSentence).forEach(System.out::println);
//        String[] words = {"El", "batjocoream", "duce", "sa", "faca", "un", "abacului"};
//        ArrayList<String> wordsArray = Arrays.asList(words).stream().map(LemmaRo::getLemma).collect(ArrayList::new,(x, y)->x.add(y),ArrayList::addAll);

    }
}

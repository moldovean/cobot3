package playground;

import org.languagetool.AnalyzedTokenReadings;
import org.languagetool.JLanguageTool;
import org.languagetool.language.Romanian;
import org.languagetool.rules.RuleMatch;
import org.languagetool.tagging.ro.RomanianTagger;

import java.io.IOException;
import java.util.List;

/**
 * Created by adri on 12/9/16.
 */
public class LanguageTools {
    public static void main(String[] args) throws IOException {
        JLanguageTool languageTool = new JLanguageTool(new Romanian());

        String sentence = "Adrian s-a trezit prea dimineaţa. Iar, Domn. Costel nu şi-a făcut temele pentru acasă.";
        sentence = sentence.replaceAll("ţ","ț").replaceAll("ş","ș");
        List<RuleMatch> matches = languageTool.check(sentence);

        for (RuleMatch match : matches) {
            System.out.println( match.getMessage() +
                    match.getFromPos() + "-" + match.getToPos() + ": ");
            System.out.println("Cuvantul: "+sentence.substring(match.getFromPos(),match.getToPos()));
            System.out.println("Sugestii pentru corecţii: " +
                    match.getSuggestedReplacements());
        }
        RomanianTagger romanianTagger = new RomanianTagger();

        List<String> list = languageTool.sentenceTokenize(sentence);
        List<AnalyzedTokenReadings> tag = romanianTagger.tag(list);

        System.out.println(list);
        System.out.println(tag);

    }
}

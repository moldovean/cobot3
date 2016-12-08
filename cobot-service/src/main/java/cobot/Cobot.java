package cobot;

import bot.CobotFactory;
import nlp.Tokenizer;
import org.alicebot.ab.Bot;
import org.alicebot.ab.Chat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by cobot on 11/24/16.
 */
public class Cobot {
    private Bot bot=null;
    private Chat chat =null;

    public Cobot(){
        bot = CobotFactory.getBot();
        chat = new Chat(bot);
    }

    public String getResponse(String utterance){
        String answer;
        Set<String> wrong = new HashSet<>(Arrays.asList("wrong","gresit","greşit"));

        //pre-bot-processing
        //System.out.println("History 0: "+getInputHistory(0));
        //System.out.println("History 1: "+getInputHistory(1));

        //System.out.println("History 2: "+getInputHistory(2));
        try{
            if (wrong.stream().anyMatch(x -> x.equalsIgnoreCase(getInputHistory(0)))) {
                answer = this.chat.multisentenceRespond(utterance);
                return answer;
            }
        } catch (NullPointerException e){
            System.out.println("Histoy is null..");
        }

        //bot-processing
        System.out.println("User typed: "+utterance);
        utterance = utterance.toLowerCase();
        utterance = Tokenizer.lemmatizeParagraph(Tokenizer.lemmatizeParagraph(Tokenizer.lemmatizeParagraph(utterance)));
        System.out.println("Bot understood: "+utterance);
        answer = this.chat.multisentenceRespond(utterance);

        //post-bot-processing
        return answer;
    }

    public String getInputHistory(int index){
        return chat.inputHistory.get(index);
    }
}

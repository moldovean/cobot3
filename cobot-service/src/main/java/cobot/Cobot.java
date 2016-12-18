package cobot;

import bot.CobotFactory;
import nlp.Tokenizer;
import org.alicebot.ab.Bot;
import org.alicebot.ab.Chat;
import util.ArgumentTokenizer;
import util.HelperClass;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        String answer="";
        Set<String> wrong = new HashSet<>(Arrays.asList("wrong","gresit","greşit"));
        Matcher matcher;
        Pattern rexExp;
        List<String> arguments;

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

        // use regex to find commands pre-bot-processing
        rexExp = Pattern.compile("``(.+?)``");
        matcher = rexExp.matcher(utterance);
        if(matcher.find()){
            arguments = ArgumentTokenizer.tokenize(matcher.group(1));
            answer = HelperClass.callHelperClass(arguments);
            return answer;
        }

        //bot-processing
        System.out.println("User typed: "+utterance);
        utterance = utterance.toLowerCase();
        // process short words

        utterance = Tokenizer.lemmatizeParagraph(Tokenizer.lemmatizeParagraph(Tokenizer.lemmatizeParagraph(utterance)));
        System.out.println("Bot understood: "+utterance);
        answer = this.chat.multisentenceRespond(utterance);

        //post-bot-processing
        rexExp = Pattern.compile("`(.+?)`");
        matcher = rexExp.matcher(answer);
        if(matcher.find()){
            arguments = ArgumentTokenizer.tokenize(matcher.group(1));
            answer += HelperClass.callHelperClass(arguments);
            return answer;
        }

        return answer;
    }

    public String getInputHistory(int index){
        return chat.inputHistory.get(index);
    }
}

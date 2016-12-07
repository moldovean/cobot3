package cobot;

import bot.CobotFactory;
import nlp.Tokenizer;
import org.alicebot.ab.Bot;
import org.alicebot.ab.Chat;

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
        //pre-bot-processing
        System.out.println("History 1: "+getInputHistory(1));
        System.out.println("History 2: "+getInputHistory(2));

        //processing
        utterance = Tokenizer.lemmatizeParagraph(Tokenizer.lemmatizeParagraph(Tokenizer.lemmatizeParagraph(utterance)));
        System.out.println(utterance);
        answer = this.chat.multisentenceRespond(utterance);

        //post-bot-processing
        return answer;
    }

    public String getInputHistory(int index){
        return chat.inputHistory.get(index);
    }
}

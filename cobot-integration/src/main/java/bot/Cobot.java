package bot;

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

        answer = this.chat.multisentenceRespond(utterance);
        return answer;
    }

    public String getinputHistory(int index){
        return chat.inputHistory.get(index);
    }


}

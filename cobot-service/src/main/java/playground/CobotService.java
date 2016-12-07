package playground;


import cobot.Cobot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by cobot on 11/24/16.
 */
public class CobotService {
    public static void main(String[] args) throws IOException {
        Cobot cobot = new Cobot();
        String input="";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(!(input.equals("q") || input.equals("bye"))){
            System.out.print("User: ");
            input = br.readLine();
            System.out.println("Bot: "+cobot.getResponse(input));
        }

    }
}

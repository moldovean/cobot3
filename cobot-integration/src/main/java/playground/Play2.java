package playground;

import bot.Cobot;

import java.util.Scanner;

/**
 * Created by cobot on 11/24/16.
 */
public class Play2 {
    public static void main(String[] args) {
        Cobot cobot = new Cobot();
        Scanner scanner = new Scanner(System.in);
        String utterance="";
        while (!(utterance.equals("bye"))){
            System.out.print("Your input: ");
            utterance = scanner.nextLine();
            System.out.println(cobot.getResponse(utterance));
        }

    }
}
package playground;


import cobot.Cobot;

/**
 * Created by cobot on 11/24/16.
 */
public class PlayCobot1 {
    public static void main(String[] args) {
        Cobot cobot = new Cobot();
        System.out.println(cobot.getResponse("salut"));;
    }
}

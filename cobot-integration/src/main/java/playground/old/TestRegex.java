package playground.old;

/**
 * Created by adri on 12/9/16.
 */
public class TestRegex {
    public static void main(String[] args) {
        String iaka = "Micada 1 random 2. si iaka 3. mai mult.";
        iaka = iaka.replaceAll("(\\d+\\.)", "\n$1");
        System.out.println(iaka);

    }
}

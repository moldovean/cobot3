package playground;

import nlp.Tokenizer;

import java.util.List;

/**
 * Created by adri on 12/9/16.
 */
public class HelperClassTest {
    public static void main(String[] args) {
        String arguments = "DexOnline getDexDefinition cartier";
        List<String> argts = util.ArgumentTokenizer.tokenize(arguments);
        System.out.println(argts);
        System.out.println(util.HelperClass.callHelperClass(argts));;
    }
}

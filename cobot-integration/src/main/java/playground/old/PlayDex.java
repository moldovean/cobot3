package playground.old;

import util.HelperClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by adri on 12/9/16.
 */
public class PlayDex {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word="";
        while(!word.equals("q")){
            System.out.print("Cauta: ");
            word = br.readLine();
            System.out.println(HelperClass.callHelperClass(Arrays.asList("DexOnline","getDexDefinition",word)));
        }
    }
}

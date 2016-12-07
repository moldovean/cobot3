package playground.old;

import nlp.LemmaRo;

import java.util.*;

/**
 * Created by adri on 12/5/16.
 */
public class LemmaIndemp2 {


    public static void main(String[] args) {
        HashMap<String,String> dic = LemmaRo.getLemmaRo();
        Set<String> keys = dic.keySet();
        Collection<String> values = dic.values();
        int counter=0;

        ArrayList<String> vals = new ArrayList<>(values);
        for (String val : vals) {
            if (val.equals(dic.get(dic.get(val)))){
                dic.remove(val);
            }
        }

        for (String value : values) {
            if(value.equals(dic.get(dic.get(value)))){
                counter++;
                //dic.remove(value);
                //System.out.println(value);
            }
        }
        System.out.println(counter);

        System.out.println("Size: "+dic.size());
    }


}

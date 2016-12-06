package playground;

import nlp.LemmaRo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by adri on 12/5/16.
 */
public class LemmaIndempotent {
    public static void main(String[] args) {
        HashMap<String,String> dic = LemmaRo.getLemmaRo();
        LemmaRo.removeRecursionLvl1();
        LemmaRo.removeRecursionLvl2();
        LemmaRo.removeRecursionLvl3();
        dic = LemmaRo.getLemmaRo();
        Set<String> keys = dic.keySet();
        Collection<String> values = dic.values();
        int level1 = 0;
        int level2 = 0;
        int recursive = 0;
        int stop = 0;
        for (String value : values) {
            if(dic.containsKey(value)){
                level1++;
                if (!(dic.get(dic.get(value)) == null)){
                    level2++;
                    if(value.equals(dic.get(dic.get(value))) && stop<20) recursive++;
                    else {
                        stop++;
                        System.out.print(value+" "+dic.get(value)+" : ");
                        System.out.println(dic.get(dic.get(value)));
                    }
                    //System.out.print(value+" "+dic.get(value)+" : ");
                    //System.out.println(dic.get(dic.get(value)));
                }


            }
        }
        System.out.println(level1);
        System.out.println(level2);
        System.out.println(recursive);
        System.out.println(stop);
        System.out.println("Size: "+dic.size());
    }
}

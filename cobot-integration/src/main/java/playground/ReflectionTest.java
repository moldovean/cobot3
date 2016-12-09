package playground;

import util.HelperClass;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static util.HelperClass.callHelperClass;


/**
 * Created by adri on 12/8/16.
 */
public class ReflectionTest {


    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        callHelperClass(new ArrayList<String>(Arrays.asList("SampleClass", "sampleRun3", "unu", "doi", "trei")));

        /*Class aClass = Class.forName("helpers." + "SampleClass");
        //Object o = aClass.newInstance();
        Method m = aClass.getDeclaredMethod("sampleRun", String.class);
        Object ret = m.invoke(aClass, "ok");
        System.out.println((String) ret);*/

        String result;
        //result = callHelperClass(new ArrayList<String>(Arrays.asList("DexOnline", "getDexDefinition", "cartier")));
        result = callHelperClass(Arrays.asList("DexOnline", "getDexDefinition", "cartier"));
        System.out.println(result);
    }
}

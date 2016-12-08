package playground;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by adri on 12/8/16.
 */
public class ReflectionTest {
    public static String callHelperClass(List<String> args) {
        Class aClass = null;
        String res = null;
        try {
            aClass = Class.forName("helpers." + args.get(0));
            Method m = aClass.getDeclaredMethod(args.get(1), List.class);
            res = (String) m.invoke(aClass, args.subList(2,args.size()));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        ReflectionTest.callHelperClass(new ArrayList<String>(Arrays.asList("SampleClass", "sampleRun3", "unu", "doi", "trei")));

        /*Class aClass = Class.forName("helpers." + "SampleClass");
        //Object o = aClass.newInstance();
        Method m = aClass.getDeclaredMethod("sampleRun", String.class);
        Object ret = m.invoke(aClass, "ok");
        System.out.println((String) ret);*/

    }
}

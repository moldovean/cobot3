package util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by adri on 12/8/16.
 */
public class HelperClass {
    public static String callHelperClass(List<String> args) {
        Class aClass = null;
        String res = null;
        try {
            aClass = Class.forName("helpers." + args.get(0));
            Object obj = aClass.newInstance();
            Method m = null;
            if (args.size() > 3) {
                m = aClass.getDeclaredMethod(args.get(1), List.class);
                res = (String) m.invoke(obj, args.subList(2,args.size()));
            } else {
                m = aClass.getDeclaredMethod(args.get(1), String.class);
                res = (String) m.invoke(obj, args.get(2));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return res;
    }
}

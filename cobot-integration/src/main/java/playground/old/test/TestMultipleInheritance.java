package playground.old.test;

/**
 * Created by adri on 12/9/16.
 */
public class TestMultipleInheritance implements A1, A2{

    @Override
    public void run() {
        A2.super.run();
    }

    public static void main(String[] args) {
        TestMultipleInheritance instance = new TestMultipleInheritance();
        instance.run();
    }
}

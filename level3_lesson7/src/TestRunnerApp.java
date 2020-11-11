import java.lang.reflect.InvocationTargetException;

public class TestRunnerApp {
    public static void main(String[] args) throws Throwable {
        TestClass testObj = new TestClass();
        Class testClass = testObj.getClass();

        TestRunner.start(testClass);
    }
}

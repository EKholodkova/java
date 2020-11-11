import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class TestRunner {

    public static void start(Class testedClass) throws Throwable{
        Object clone = testedClass.getDeclaredConstructor().newInstance();

        List<Method> firstMethods = getMethods(testedClass, BeforeSuite.class);
        List<Method> lastMethods = getMethods(testedClass, AfterSuite.class);
        if(firstMethods.size() != 1 || lastMethods.size() != 1) {
            throw new RuntimeException();
        }
        Method firstMethod = firstMethods.get(0);
        firstMethod.setAccessible(true);
        firstMethod.invoke(clone);


        Map<Integer, Method> prioritisedTests = new TreeMap<Integer, Method>(Collections.reverseOrder());
        for(Method m : getMethods(testedClass, Test.class)) {
            Test a = m.getAnnotation(Test.class);
            int p = a.priority();
            prioritisedTests.put(p, m);
        }
        for(Map.Entry<Integer, Method> pair : prioritisedTests.entrySet()) {
            pair.getValue().setAccessible(true);
            pair.getValue().invoke(clone);
        }


        Method lastMethod = lastMethods.get(0);
        lastMethod.setAccessible(true);
        lastMethod.invoke(clone);
    }

    public static List<Method> getMethods(Class testedClass, Class annotationClass) {
        List<Method> requestedMethods = new ArrayList<Method>();
        Method[] methods = testedClass.getDeclaredMethods();
        for(Method method : methods) {
            Annotation[] annotations = method.getDeclaredAnnotations();
            for(Annotation annotation : annotations) {
                if(annotationClass.equals(annotation.annotationType())) {
                    requestedMethods.add(method);
                }
            }
        }
        return requestedMethods;
    }
}

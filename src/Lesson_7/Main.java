package Lesson_7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws Exception {
        Class cl = ClassForTest.class;
        Method[] methods = cl.getDeclaredMethods();
        ArrayList<Method> arr = new ArrayList();
        int countBefore = 0;
        int countAfter = 0;

        for (Method m : methods) {
            if (m.isAnnotationPresent(BeforeSuite.class)) {
                countBefore++;
                if (countBefore > 1) {
                    throw new RuntimeException("Может быть только один метод с аннотацией BeforeSuite");
                }
            }

            if (m.isAnnotationPresent(AfterSuite.class)) {
                countAfter++;
                if (countAfter > 1) {
                    throw new RuntimeException("Может быть только один метод с аннотацией AfterSuite");
                }
            }

            if (m.isAnnotationPresent(Test.class)) {
                arr.add(m);
            }

            arr.sort(new Comparator<Method>() {
                @Override
                public int compare(Method o1, Method o2) {
                    return o1.getAnnotation(Test.class).priority() - o2.getAnnotation(Test.class).priority();
                }
            });
        }

        for (Method before : methods) {
            if (before.isAnnotationPresent(BeforeSuite.class))
            before.invoke(null);
        }

        for (Method tests : arr) {
            tests.invoke(null);
        }

        for (Method after : methods) {
            if (after.isAnnotationPresent(AfterSuite.class))
            after.invoke(null);
        }

    }
}

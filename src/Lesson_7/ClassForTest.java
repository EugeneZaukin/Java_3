package Lesson_7;

public class ClassForTest {

    @BeforeSuite
    public static void before() {
        System.out.println("Начало тестов");
    }

    @Test(priority = 2)
    public static void test1() {
        System.out.println("Тест 1");
    }

    @Test(priority = 4)
    public static void test2() {
        System.out.println("Тест 2");
    }

    @Test(priority = 5)
    public static void test3() {
        System.out.println("Тест 3");
    }

    @Test(priority = 3)
    public static void test4() {
        System.out.println("Тест 4");
    }

    @Test(priority = 1)
    public static void test5() {
        System.out.println("Тест 5");
    }

    @AfterSuite
    public static void after() {
        System.out.println("Конец тестов");
    }
//    @AfterSuite
//    public static void after1() {
//        System.out.println("Конец тестов");
//    }
}

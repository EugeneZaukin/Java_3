package Lesson_1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer[] arr1 = {1, 2, 3, 4, 5, 6};
        String[] arr2 = {"a", "b", "c", "d"};
        swapElArr(arr1, 1, 3);
        swapElArr(arr2, 0,3);

        Generic<String> arr3 = new Generic<String>(new String[] {"a", "b", "c"});
        arr3.createArrList();

        Box<Apple> appleBox= new Box<>();
        Apple a1 = new Apple();
        Apple a2 = new Apple();

        appleBox.addFruit(a1);
        appleBox.addFruit(a2);


        Box<Orange> orangeBox1 = new Box<>();
        Box<Orange> orangeBox2 = new Box<>();
        Orange or1 = new Orange();
        Orange or2 = new Orange();

        orangeBox1.addFruit(or1);
        orangeBox1.addFruit(or2);

        System.out.println("Вес коробки с яблоками: " + appleBox.getAllWeight());
        System.out.println("Вес коробки с апельсинами: " + orangeBox1.getAllWeight());
        System.out.println("Сравниваем вес коробки яблок с апельсинами: " + appleBox.compare(orangeBox1));
        System.out.println(orangeBox2.getAllWeight());
        orangeBox1.replaceFruits(orangeBox2);
        System.out.println(orangeBox2.getAllWeight());
    }

    public static void swapElArr(Object[] arr, int a, int b) {
        System.out.println("Массив: " + Arrays.toString(arr));
        Object swap = arr[a];
        arr[a] = arr[b];
        arr[b] = swap;
        System.out.println("Результат обмена: " + Arrays.toString(arr));
    }
}

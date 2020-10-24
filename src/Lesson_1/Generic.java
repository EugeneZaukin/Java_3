package Lesson_1;

import java.util.ArrayList;
import java.util.Arrays;

public class Generic<T> {
    private T[] object;

    public Generic(T[] object) {
        this.object = object;
    }

    public T[] getObject() {
        return object;
    }

    public ArrayList<T> createArrList() {
        ArrayList<T> arrList = new ArrayList<T>(Arrays.asList(object));
        System.out.println(arrList);
        return arrList;
    }
}
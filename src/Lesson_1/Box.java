package Lesson_1;

import java.util.ArrayList;

public class Box <T extends Fruit> {
    private ArrayList<T> fruits;
    private float weight;

    public Box() {
        fruits = new ArrayList<>();
    }

    public Box(ArrayList<T> fruits) {
        this.fruits = fruits;
    }

    public ArrayList<T> getFruits() {
        return fruits;
    }

    public void setFruits(ArrayList<T> fruits) {
        this.fruits = fruits;
    }

    public void addFruit(T addF) {
        fruits.add(addF);
    }

    public float getAllWeight() {
        if (fruits.size() != 0) {
            int i = 0;
            weight = fruits.size() * fruits.get(i).getWeight();
        } else {
            System.out.println("Нет фруктов в коробке!");
        }
        return weight;
    }

    public boolean compare(Box<?> otherBox) {
        return getAllWeight() == otherBox.getAllWeight();
    }

    public void replaceFruits(Box<T> box) {
        box.fruits.addAll(fruits);
        fruits.clear();
    }
}
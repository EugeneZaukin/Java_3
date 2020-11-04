package Lesson_5;

import java.security.cert.CertificateNotYetValidException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Car implements Runnable{
    private static int CARS_COUNT;
    private Race race;
    private int speed;
    private String name;
    private static CyclicBarrier cb;
    private static Lock lock = new ReentrantLock();
    private static CountDownLatch win = new CountDownLatch(2);

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed, CyclicBarrier cb1) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        this.cb = cb1;
    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            cb.await();
            cb.await();

            for (int i = 0; i < race.getStages().size(); i++) {
                race.getStages().get(i).go(this);
            }

            synchronized (lock) {
                win.countDown();
                if (win.getCount() == 1) {
                    System.out.println(this.name + " Победил!");
                }
            }
            cb.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
